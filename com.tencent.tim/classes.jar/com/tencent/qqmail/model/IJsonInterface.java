package com.tencent.qqmail.model;

import com.alibaba.fastjson.JSONObject;

public abstract interface IJsonInterface
{
  public abstract JSONObject fromJson(String paramString);
  
  public abstract String toJson();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.IJsonInterface
 * JD-Core Version:    0.7.0.1
 */