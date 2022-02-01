import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class san
{
  public CertifiedAccountMeta.StShare a;
  public boolean aKJ;
  public boolean aKK = true;
  public boolean ayK;
  public ExtraTypeInfo mExtraTypeInfo;
  public CertifiedAccountMeta.StFeed mFeed;
  public String mUrl;
  public int shareFromType;
  
  public CertifiedAccountMeta.StFeed a()
  {
    return this.mFeed;
  }
  
  public String getShareTitle()
  {
    if ((this.a != null) && (!aqmr.isEmpty(this.a.title.get())))
    {
      QLog.e("ShareInfoBean", 1, this.a.title.get());
      return this.a.title.get();
    }
    if (this.mFeed != null)
    {
      if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType == 7002)) {
        return this.mFeed.poster.nick.get();
      }
      return this.mFeed.title.get();
    }
    return "";
  }
  
  public String np()
  {
    if (this.a != null) {
      return this.a.author.id.get();
    }
    return "";
  }
  
  public String nq()
  {
    if ((this.a != null) && (!aqmr.isEmpty(this.a.url.get())))
    {
      QLog.e("ShareInfoBean", 1, this.a.url.get());
      return this.a.url.get();
    }
    if ((this.mFeed == null) || (this.mExtraTypeInfo == null))
    {
      if (this.mUrl == null) {
        return "";
      }
      return this.mUrl;
    }
    String str;
    switch (this.mExtraTypeInfo.pageType)
    {
    default: 
      if (this.mUrl == null) {
        str = "";
      }
      break;
    }
    for (;;)
    {
      QLog.d("ShareInfoBean", 1, "share url is:" + str);
      return str;
      str = siu.e(this.mFeed);
      continue;
      str = siu.c(this.mFeed);
      continue;
      str = siu.d(this.mFeed);
      continue;
      str = siu.b(this.mFeed);
      continue;
      str = this.mUrl;
    }
  }
  
  public String nr()
  {
    if ((this.a != null) && (!aqmr.isEmpty(this.a.desc.get())))
    {
      QLog.e("ShareInfoBean", 1, this.a.desc.get());
      return this.a.desc.get();
    }
    if (this.mFeed != null)
    {
      if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType == 7002)) {
        return this.mFeed.poster.desc.get();
      }
      return this.mFeed.subtitle.get();
    }
    return "";
  }
  
  public String ns()
  {
    if ((this.a != null) && (!aqmr.isEmpty(this.a.cover.url.get())))
    {
      QLog.e("ShareInfoBean", 1, this.a.cover.url.get());
      return this.a.cover.url.get();
    }
    if (this.mFeed != null)
    {
      if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType == 7002)) {
        return this.mFeed.poster.icon.get();
      }
      return this.mFeed.cover.url.get();
    }
    return "";
  }
  
  public String nt()
  {
    if ((this.a != null) && (!aqmr.isEmpty(this.a.author.nick.get()))) {
      return this.a.author.nick.get();
    }
    if (this.mFeed != null) {
      return this.mFeed.poster.nick.get();
    }
    return "";
  }
  
  public String nu()
  {
    if ((this.a != null) && (!aqmr.isEmpty(this.a.author.desc.get()))) {
      return this.a.author.desc.get();
    }
    if (this.mFeed != null) {
      return this.mFeed.poster.desc.get();
    }
    return "";
  }
  
  public String nv()
  {
    if ((this.a != null) && (!aqmr.isEmpty(this.a.shorturl.get()))) {
      return this.a.shorturl.get();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     san
 * JD-Core Version:    0.7.0.1
 */