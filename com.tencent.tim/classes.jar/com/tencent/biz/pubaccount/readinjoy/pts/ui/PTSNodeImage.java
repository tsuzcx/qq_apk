package com.tencent.biz.pubaccount.readinjoy.pts.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.qphone.base.util.QLog;
import kxm;
import lvz;

public class PTSNodeImage
  extends PTSNodeVirtual<PTSImageView>
{
  public static final String TAG = "PTSNodeImage";
  private long uin;
  
  private PTSNodeImage(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  private String addSmartCrop(String paramString)
  {
    int i = getNodeInfo().getStyle().getWidth();
    int j = getNodeInfo().getStyle().getHeight();
    String str = paramString;
    if (i > 0)
    {
      str = paramString;
      if (j > 0) {
        str = kxm.c(paramString, i, j);
      }
    }
    return str;
  }
  
  private void loadAvatarByUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("PTSNodeImage", 1, "[loadAvatarByUin] uin is null");
    }
    for (;;)
    {
      return;
      try
      {
        long l = Long.parseLong(paramString);
        this.uin = l;
        paramString = ReadInJoyUserInfoModule.a(l, new PTSNodeImage.1(this));
        if (paramString != null)
        {
          paramString = ReadInJoyUserInfoModule.a(paramString);
          ((PTSImageView)getView()).setImageSrc(paramString);
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("PTSNodeImage", 1, "[loadAvatarByUin] error, e = " + paramString);
      }
    }
  }
  
  private void setImageSrc(String paramString)
  {
    PTSTimeCostUtil.start("image-" + paramString);
    ((PTSImageView)getView()).setImageDrawable(((PTSImageView)getView()).getResources().getDrawable(2130842541));
    if (!TextUtils.isEmpty(paramString))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label167;
      }
      String str = addSmartCrop(paramString);
      PTSLog.i("PTSNodeImage", "[setImageSrc], cropUrl = " + str);
      ((PTSImageView)getView()).setImageSrc(str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTSNodeImage", 2, "[setImageSrc], path = " + paramString);
      }
      PTSTimeCostUtil.end("image-" + paramString);
      return;
      label167:
      if (paramString.startsWith("images")) {
        lvz.a((PTSImageView)getView(), paramString);
      } else {
        loadAvatarByUin(paramString);
      }
    }
  }
  
  public boolean setAttribute(String paramString, Object paramObject)
  {
    if (super.setAttribute(paramString, paramObject)) {
      return true;
    }
    if (("src".equals(paramString)) && ((paramObject instanceof String)))
    {
      setImageSrc((String)paramObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeImage
 * JD-Core Version:    0.7.0.1
 */