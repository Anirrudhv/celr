package com.example.anirudhv.celr_demo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

String Base_Url = "http://private-04a55-videoplayer1.apiary-mock.com/";

@GET ("pictures")
    Call <List<Celr>> getCelr();
}

