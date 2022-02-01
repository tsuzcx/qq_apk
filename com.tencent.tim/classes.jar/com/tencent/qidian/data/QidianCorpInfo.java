package com.tencent.qidian.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qidian.proto.mobileqq_qidian.CorpInfo;
import java.util.Arrays;

public class QidianCorpInfo
  extends Entity
{
  public String corpAddr = "";
  public String corpCall = "";
  public String corpCode = "";
  public String corpFullName = "";
  public String corpHome = "";
  public String corpIntro = "";
  public String corpLogo = "";
  public String corpName = "";
  @unique
  public String corpUin = "";
  public byte[] infoByte;
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    paramObject = (QidianCorpInfo)paramObject;
    return Arrays.equals(this.infoByte, paramObject.infoByte);
  }
  
  public void from(mobileqq_qidian.CorpInfo paramCorpInfo)
  {
    this.infoByte = paramCorpInfo.toByteArray();
    if (paramCorpInfo.str_corp_intro.has()) {
      this.corpIntro = paramCorpInfo.str_corp_intro.get();
    }
    if (paramCorpInfo.str_homepage.has()) {
      this.corpHome = paramCorpInfo.str_homepage.get();
    }
    if (paramCorpInfo.str_address.has()) {
      this.corpAddr = paramCorpInfo.str_address.get();
    }
    if (paramCorpInfo.str_corp_call.has()) {
      this.corpCall = paramCorpInfo.str_corp_call.get();
    }
    if (paramCorpInfo.str_postcode.has()) {
      this.corpCode = paramCorpInfo.str_postcode.get();
    }
    if (paramCorpInfo.str_logo.has()) {
      this.corpLogo = paramCorpInfo.str_logo.get();
    }
    if (paramCorpInfo.str_corp_short_name.has()) {
      this.corpName = paramCorpInfo.str_corp_short_name.get();
    }
    if (paramCorpInfo.uint64_master_uin.has()) {
      this.corpUin = String.valueOf(paramCorpInfo.uint64_master_uin.get());
    }
    if (paramCorpInfo.str_corp_full_name.has()) {
      this.corpFullName = paramCorpInfo.str_corp_full_name.get();
    }
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.infoByte);
  }
  
  public mobileqq_qidian.CorpInfo to()
  {
    mobileqq_qidian.CorpInfo localCorpInfo = new mobileqq_qidian.CorpInfo();
    localCorpInfo.str_corp_short_name.set(this.corpName);
    localCorpInfo.str_corp_intro.set(this.corpIntro);
    localCorpInfo.str_homepage.set(this.corpHome);
    localCorpInfo.str_address.set(this.corpAddr);
    localCorpInfo.str_corp_call.set(this.corpCall);
    localCorpInfo.str_postcode.set(this.corpCode);
    localCorpInfo.str_logo.set(this.corpLogo);
    localCorpInfo.uint64_master_uin.set(Long.parseLong(this.corpUin));
    localCorpInfo.str_corp_full_name.set(this.corpFullName);
    return localCorpInfo;
  }
  
  public void update(QidianCorpInfo paramQidianCorpInfo)
  {
    if ((paramQidianCorpInfo != null) && (this.corpUin.equals(paramQidianCorpInfo.corpUin)))
    {
      if (!TextUtils.isEmpty(paramQidianCorpInfo.corpAddr)) {
        this.corpAddr = paramQidianCorpInfo.corpAddr;
      }
      if (!TextUtils.isEmpty(paramQidianCorpInfo.corpHome)) {
        this.corpHome = paramQidianCorpInfo.corpHome;
      }
      if (!TextUtils.isEmpty(paramQidianCorpInfo.corpIntro)) {
        this.corpIntro = paramQidianCorpInfo.corpIntro;
      }
      if (!TextUtils.isEmpty(paramQidianCorpInfo.corpCall)) {
        this.corpCall = paramQidianCorpInfo.corpCall;
      }
      if (!TextUtils.isEmpty(paramQidianCorpInfo.corpCode)) {
        this.corpCode = paramQidianCorpInfo.corpCode;
      }
      if (!TextUtils.isEmpty(paramQidianCorpInfo.corpLogo)) {
        this.corpLogo = paramQidianCorpInfo.corpLogo;
      }
      if (!TextUtils.isEmpty(paramQidianCorpInfo.corpName)) {
        this.corpName = paramQidianCorpInfo.corpName;
      }
      if (!TextUtils.isEmpty(paramQidianCorpInfo.corpFullName)) {
        this.corpFullName = paramQidianCorpInfo.corpFullName;
      }
      this.infoByte = to().toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.data.QidianCorpInfo
 * JD-Core Version:    0.7.0.1
 */