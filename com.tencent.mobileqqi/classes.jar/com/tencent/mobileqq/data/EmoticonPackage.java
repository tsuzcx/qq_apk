package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.persistence.unique;

public class EmoticonPackage
  extends Entity
{
  public static final int EmoticonPkgNeverUpdateBit = 2;
  public static final int EmoticonPkgRedPointBit = 4;
  public static final int EmoticonPkgUpdateBit = 1;
  public static final int JOB_MAGIC = 3;
  public static final int JOB_NORMAL = 0;
  public static final int JOB_QFACE = 2;
  public static final int JOB_QFACE_MATERIAL = 1;
  public static final String MAGIC_FACE_EPID = "100000";
  public static final int TYPE_MAGIC = 1;
  public String author;
  public int downloadCount;
  @unique
  public String epId;
  public long expiretime;
  public String firstEmotionId;
  public boolean hasReadUpdatePage;
  public boolean hasSound;
  public boolean isMagicFaceDownloading;
  public boolean isRecommendation;
  public int jobType;
  @defaultzero
  public int jsonVersion;
  public String kinId;
  public int latestVersion;
  public int localVersion;
  public String mark;
  public int mobileFeetype;
  public String name;
  public int status;
  public int type;
  public int updateFlag;
  public String updateTip;
  public int upperLeftLable;
  public boolean valid;
  public long wordingId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.EmoticonPackage
 * JD-Core Version:    0.7.0.1
 */