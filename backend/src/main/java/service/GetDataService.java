package service;

import model.Content;
import model.Hot;

import java.util.List;

public interface GetDataService {

    public List<Content> getContent();

    public List<Hot> getHot();
}
