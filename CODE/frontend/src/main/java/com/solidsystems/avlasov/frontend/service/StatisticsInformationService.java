package com.solidsystems.avlasov.frontend.service;

import com.solidsystems.avlasov.frontend.entity.StatisticsInfo;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex Vlasov on 24.10.15.
 */
public class StatisticsInformationService implements Runnable {

    private static StatisticsInformationService instance;

    private ScheduledExecutorService ex = Executors.newScheduledThreadPool(1);
    private int updateInterval = 2;
    private int startDelay = 0;
    private boolean isProcess = false;
    private Set<StatisticsServiceListener> listeners = new HashSet<StatisticsServiceListener>();

    private StatisticsInformationService() {
    }

    public static synchronized StatisticsInformationService getInstance() {
        if(instance == null)
            instance = new StatisticsInformationService();
        return instance;
    }

    public void run() {
        isProcess = true;
        StatisticsInfo info = new StatisticsInfo();
        long time = System.currentTimeMillis();
        info.setA(info.getA() + time);
        info.setB(info.getB() + time);
        notifyListeners(info);
        isProcess = false;
    }

    public void start() {
        ex.scheduleWithFixedDelay(this, startDelay, updateInterval, TimeUnit.SECONDS);
    }

    public void addListener(StatisticsServiceListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners(StatisticsInfo info) {
        for(StatisticsServiceListener l: listeners)
            l.changeContent(info);
    }



}
