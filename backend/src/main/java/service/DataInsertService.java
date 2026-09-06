package service;

import model.Content;
import model.Hot;

import java.util.List;

public interface DataInsertService {

    public List<Content> getApiContent();

    public List<Hot> getApiHot();
}
