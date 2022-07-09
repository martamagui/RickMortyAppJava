package com.marta.rickmortyappjava.api.model;

import java.util.ArrayList;
import java.util.List;

public class Response {
    ArrayList<ResultResponse> results = new ArrayList<ResultResponse>();

    public ArrayList<ResultResponse> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultResponse> results) {
        this.results = results;
    }
}
