package com.solidsystems.avlasov.backend.beans.data.manager;

import java.io.Serializable;
import java.util.List;

public interface AbstractDataManager<T, PK extends Serializable> {

    T read(PK id);

    PK save(T transientObject);

    void delete(T persistentObject);

    List<T> list();
}