package com.tencent.mobileqq.search.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public a clueWordItem;
  public b groupID;
  public List<c> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(b paramb, List<c> paramList, a parama)
  {
    this.groupID = paramb;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = parama;
  }
  
  public static class a
  {
    public String cbf;
    public String word;
    
    public a() {}
    
    public a(String paramString1, String paramString2)
    {
      this.cbf = paramString1;
      this.word = paramString2;
    }
  }
  
  public static class b
  {
    public List<Long> FS;
    
    public b() {}
    
    public b(List<Long> paramList)
    {
      this.FS = paramList;
    }
  }
  
  public static class c
  {
    public String word;
    public String wordId;
    
    public c() {}
    
    public c(String paramString1, String paramString2)
    {
      this.wordId = paramString1;
      this.word = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */