package com.tencent.mobileqq.transfile.chatpic;

import acei;
import acfx;
import akxr;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import aool;
import aoom;
import aoop;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.CustomError;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class PicDownloadExplicitError
  extends CustomError
{
  public static final String C2C_PIC_REQUEST_EXPIRED_DESC = "T_208";
  public static final String GROUP_PIC_EXPIRED_DESC = "H_404_-6101";
  public static final String GROUP_PIC_REQUEST_EXPIRED_DESC = "T_203";
  public static final String GROUP_PIC_REQUEST_QUERY_INDEX_TIMEOUT_DESC = "T_206";
  public static final String TAG = "PicDownloadExplicitError";
  private static final Map<Integer, a> mMap = new HashMap();
  private int mErrCode;
  
  static
  {
    mMap.put(Integer.valueOf(1), new a(2130838157, 2131690211));
    mMap.put(Integer.valueOf(2), new a(-1, 2131690212));
    mMap.put(Integer.valueOf(3), new a(-1, 2131690213));
  }
  
  private PicDownloadExplicitError(int paramInt)
  {
    this.mErrCode = paramInt;
  }
  
  private String AP()
  {
    a locala = (a)mMap.get(Integer.valueOf(this.mErrCode));
    if (locala != null)
    {
      int i = locala.KU();
      if (i > 0) {
        return BaseApplicationImpl.getApplication().getResources().getString(i);
      }
    }
    return BaseApplicationImpl.getApplication().getResources().getString(2131690211);
  }
  
  private static PicDownloadExplicitError a(akxr paramakxr)
  {
    return null;
  }
  
  private static PicDownloadExplicitError a(aoom paramaoom)
  {
    Object localObject = paramaoom.i;
    long l;
    String str;
    if (localObject != null)
    {
      l = paramaoom.aqr;
      str = paramaoom.clO;
      int i = ((aool)localObject).mUinType;
      localObject = ((aool)localObject).F;
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        if ((acfx.W((MessageRecord)localObject)) || (acei.W((MessageRecord)localObject))) {
          return null;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PicDownloadExplicitError", 2, "getError,errCode:" + l + " errDesc:" + str + " uinType:" + i);
      }
      if ((i == 1) || (i == 3000)) {
        if (l == -9527L)
        {
          if ((!"H_404_-6101".equals(str)) && (!"T_203".equals(str)) && (!"T_206".equals(str))) {
            break label311;
          }
          paramaoom = new PicDownloadExplicitError(1);
        }
      }
    }
    for (;;)
    {
      return paramaoom;
      if (paramaoom.aqr == 9302L)
      {
        paramaoom = new PicDownloadExplicitError(2);
      }
      else
      {
        if ((l == 9039L) || (l == 9040L))
        {
          paramaoom = new PicDownloadExplicitError(3);
          continue;
          if (l == -9527L)
          {
            if ("T_208".equals(str)) {
              paramaoom = new PicDownloadExplicitError(1);
            }
          }
          else
          {
            if (paramaoom.aqr == 9302L)
            {
              paramaoom = new PicDownloadExplicitError(2);
              continue;
            }
            if ((l == 9039L) || (l == 9040L))
            {
              paramaoom = new PicDownloadExplicitError(3);
              continue;
            }
          }
        }
        label311:
        paramaoom = null;
      }
    }
  }
  
  public static String getFailedTip(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getStateError() instanceof PicDownloadExplicitError)) {
      return ((PicDownloadExplicitError)paramURLDrawable.getStateError()).AP();
    }
    return null;
  }
  
  public static PicDownloadExplicitError getPicError(Object paramObject)
  {
    if ((paramObject instanceof aoom)) {
      return a((aoom)paramObject);
    }
    if ((paramObject instanceof akxr)) {
      return a((akxr)paramObject);
    }
    return null;
  }
  
  public Drawable getFailedDrawable()
  {
    a locala = (a)mMap.get(Integer.valueOf(this.mErrCode));
    if (locala != null)
    {
      int i = locala.KT();
      if (i > 0) {
        return aoop.D(i);
      }
    }
    return aoop.getFailedDrawable();
  }
  
  static class a
  {
    int dRc;
    int dRd;
    
    public a(int paramInt1, int paramInt2)
    {
      this.dRc = paramInt1;
      this.dRd = paramInt2;
    }
    
    int KT()
    {
      return this.dRc;
    }
    
    int KU()
    {
      return this.dRd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError
 * JD-Core Version:    0.7.0.1
 */