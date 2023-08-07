package id.amartek.app.service.generic;

import java.util.List;

import id.amartek.app.model.Division;
import id.amartek.app.model.Region;

public interface GenericServices<T> {
    public Boolean Save(T model);

    public T Get(int id);

    public List<T> getAll();

    public Boolean Delete(int id);
}
