package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import lbz;
import ljc;
import ndi;
import nlh;
import npi;
import org.json.JSONObject;

public class AuthorData
  extends ProteusItemData
{
  public String accountName;
  public String alY;
  public String alZ;
  public ArticleInfo articleInfo;
  public boolean atm;
  private boolean atn;
  public String authorName;
  public String hH;
  public long xI;
  
  public AuthorData(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    super(25);
    this.articleInfo = paramArticleInfo;
    this.d = paramFastWebArticleInfo;
  }
  
  private long getUin()
  {
    try
    {
      long l = Long.parseLong(this.articleInfo.mSubscribeID);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void aBI()
  {
    if (this.articleInfo != null)
    {
      boolean bool = lbz.a().dI(this.articleInfo.getSubscribeUin());
      if (bool != this.atm)
      {
        this.atm = bool;
        aZq();
      }
    }
  }
  
  public void aOi()
  {
    Object localObject;
    ljc localljc;
    long l;
    nlh localnlh;
    if (!this.atm)
    {
      pQ(true);
      if ((this.articleInfo != null) && (this.d != null))
      {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localljc = lbz.a().a();
        localObject = ((QQAppInterface)localObject).getAccount();
        l = getUin();
        localnlh = new nlh(this);
        if (!ndi.ak(this.articleInfo)) {
          break label92;
        }
      }
    }
    label92:
    for (int i = 2;; i = 1)
    {
      localljc.a((String)localObject, l, true, localnlh, i);
      return;
    }
  }
  
  public void aZq()
  {
    int i = 1;
    if ((this.d != null) && (this.d.FP())) {}
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        if (i != 0)
        {
          localJSONObject.put("style_ID", "ReadInjoy_article_relocated_header_cell");
          localJSONObject.put("avatar_url", this.alY);
          localJSONObject.put("avatar_uin", this.hH);
          localJSONObject.put("nickname_text", this.accountName);
          localJSONObject.put("timestamp_text", this.alZ);
          if (this.xI > 0L)
          {
            if ((this.atn) || (!this.atm))
            {
              if (!this.atm) {
                break label260;
              }
              localJSONObject.put("selected_status", "1");
            }
            Object localObject1 = this.amd;
            if (localObject1 != null) {
              try
              {
                localObject1 = new JSONObject(this.amd);
                Iterator localIterator = ((JSONObject)localObject1).keys();
                if (localIterator == null) {
                  break label272;
                }
                if (!localIterator.hasNext()) {
                  break label272;
                }
                String str = (String)localIterator.next();
                localJSONObject.put(str, ((JSONObject)localObject1).opt(str));
                continue;
                localObject2 = npi.a("native_article", true);
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
              }
            }
            if (localObject2 == null) {
              break label303;
            }
            Object localObject2 = ((npi)localObject2).getTemplateBean(localJSONObject);
            if (localObject2 == null) {
              break label308;
            }
            this.mTemplateBean = ((TemplateBean)localObject2);
            this.aD = localJSONObject;
          }
        }
        else
        {
          localJSONObject.put("style_ID", "ReadInjoy_article_header_cell");
          continue;
        }
        localJSONObject.put("read_amount_text", "0");
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return;
      }
      continue;
      label260:
      localJSONObject.put("selected_status", "0");
      continue;
      label272:
      QLog.d("AuthorData", 2, "merge result: " + localJSONObject.toString());
      continue;
      label303:
      Object localObject3 = null;
      continue;
      label308:
      return;
      i = 0;
    }
  }
  
  public void eS(long paramLong)
  {
    this.xI = paramLong;
    aZq();
  }
  
  public void pQ(boolean paramBoolean)
  {
    this.atm = paramBoolean;
    this.atn = true;
    aZq();
  }
  
  public void pR(boolean paramBoolean)
  {
    this.atn = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData
 * JD-Core Version:    0.7.0.1
 */