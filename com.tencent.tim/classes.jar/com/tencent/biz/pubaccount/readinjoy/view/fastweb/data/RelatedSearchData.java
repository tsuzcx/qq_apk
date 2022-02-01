package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import java.util.ArrayList;
import java.util.List;

public class RelatedSearchData
  extends BaseData
{
  public List<a> kl;
  public String sid;
  
  public RelatedSearchData(FastWebArticleInfo paramFastWebArticleInfo)
  {
    super(20);
    this.d = paramFastWebArticleInfo;
    this.kl = new ArrayList();
  }
  
  public static class a
  {
    public int bah;
    public String jumpUrl;
    public String modelName;
    public float score;
    public String word;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData
 * JD-Core Version:    0.7.0.1
 */