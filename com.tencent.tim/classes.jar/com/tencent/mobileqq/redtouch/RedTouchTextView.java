package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import aqhu;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouchTextView
  extends TextView
{
  private List<BusinessInfoCheckUpdate.RedTypeInfo> Fr;
  private int bHY = 100;
  private String bPN = "";
  private BusinessInfoCheckUpdate.AppInfo c;
  private int dxq = iJ(30);
  private int dxr = iJ(9);
  private int dxs = iJ(9);
  private int dxt = iJ(4);
  public Drawable fs;
  public Drawable ft;
  public String imgUrl = "";
  private boolean isDownloading;
  private Rect mTextBounds = new Rect();
  private Handler mUiHandler;
  
  public RedTouchTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int In()
  {
    String str = getText().toString();
    TextPaint localTextPaint = getPaint();
    localTextPaint.getTextBounds(str, 0, str.length(), this.mTextBounds);
    float f = Layout.getDesiredWidth(str, localTextPaint);
    return (int)(getWidth() - f - getPaddingLeft() - iJ(0) - iJ(0));
  }
  
  private int a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (paramRedTypeInfo == null)
    {
      j = i;
      return j;
    }
    int k = paramRedTypeInfo.red_type.get();
    i = j;
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoWidth type = " + k + ",width = " + i);
      return i;
      i = this.dxr;
      continue;
      if (a(paramRedTypeInfo, this.c))
      {
        i = this.dxq + this.dxt;
      }
      else
      {
        i = this.dxq;
        continue;
        paramRedTypeInfo = paramRedTypeInfo.red_content.get();
        try
        {
          i = Integer.valueOf(paramRedTypeInfo).intValue();
        }
        catch (Exception paramRedTypeInfo)
        {
          QLog.e("RedTouchTextView", 1, "getRedTypeInfoWidth exception e = ", paramRedTypeInfo);
          i = j;
        }
        continue;
        this.bPN = paramRedTypeInfo.red_content.get();
        paramRedTypeInfo = new TextPaint();
        paramRedTypeInfo.setTextSize(iJ(11));
        j = (int)paramRedTypeInfo.measureText(this.bPN);
        i = j;
        if (paramBoolean) {
          i = j + iJ(6) * 2;
        }
      }
    }
  }
  
  public static List<BusinessInfoCheckUpdate.RedTypeInfo> a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      paramAppInfo = null;
    }
    List localList;
    do
    {
      return paramAppInfo;
      paramAppInfo = (BusinessInfoCheckUpdate.RedDisplayInfo)paramAppInfo.red_display_info.get();
      if (paramAppInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null");
        }
        return null;
      }
      localList = paramAppInfo.red_type_info.get();
      if (localList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null");
        }
        return null;
      }
      paramAppInfo = localList;
    } while (localList.size() >= 2);
    if (QLog.isColorLevel()) {
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos.size < 2");
    }
    return null;
  }
  
  private void a(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
    throws JSONException
  {
    int j;
    int k;
    int i;
    if (paramInt2 == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch img");
      }
      j = getWidth() - h(this.Fr, paramInt1) - iJ(0);
      k = getHeight() / 2 - this.dxq / 2;
      paramInt1 = 0;
      paramInt2 = 0;
      i = 0;
      if (paramJSONObject.has("av")) {
        paramInt1 = paramJSONObject.getInt("av");
      }
      if (paramJSONObject.has("dot")) {
        paramInt2 = paramJSONObject.getInt("dot");
      }
      if (paramJSONObject.has("st")) {
        i = Integer.valueOf(paramJSONObject.getString("st")).intValue();
      }
      paramRedTypeInfo = paramRedTypeInfo.red_content.get();
      if (i != 1) {
        break label267;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch img gif ");
      }
      paramJSONObject = getResources().getDrawable(2130840645);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramJSONObject;
      localURLDrawableOptions.mFailedDrawable = paramJSONObject;
      localURLDrawableOptions.mRequestWidth = this.dxq;
      localURLDrawableOptions.mRequestHeight = this.dxq;
      localURLDrawableOptions.mPlayGifImage = true;
      paramRedTypeInfo = URLDrawable.getDrawable(paramRedTypeInfo, localURLDrawableOptions);
      paramRedTypeInfo.setCallback(this);
      paramRedTypeInfo.draw(paramCanvas);
      if (this.ft != null)
      {
        this.ft.setBounds(j, k, this.dxq + j, this.dxq + k);
        this.ft.draw(paramCanvas);
      }
    }
    label267:
    while (i != 0)
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedTouchTextView", 2, "draw redtouch img static ");
    }
    if (this.ft == null)
    {
      paramJSONObject = getResources().getDrawable(2130840645);
      paramJSONObject.setBounds(j, k, this.dxq + j, this.dxq + k);
      paramJSONObject.draw(paramCanvas);
    }
    for (;;)
    {
      if (paramInt2 == 1)
      {
        paramJSONObject = getResources().getDrawable(2130851400);
        paramJSONObject.setBounds(getWidth() - iJ(0) - iJ(9), k - iJ(4), getWidth() - iJ(0), k + iJ(5));
        paramJSONObject.draw(paramCanvas);
      }
      if ((this.ft != null) || (TextUtils.isEmpty(paramRedTypeInfo))) {
        break;
      }
      ThreadManager.post(new RedTouchTextView.1(this, paramRedTypeInfo, paramInt1), 8, null, true);
      return;
      this.ft.setBounds(j, k, this.dxq + j, this.dxq + k);
      this.ft.draw(paramCanvas);
    }
  }
  
  public static boolean a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool = true;
    if ((paramRedTypeInfo == null) || (paramRedTypeInfo.red_type.get() != 3))
    {
      bool = false;
      return bool;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramRedTypeInfo.red_desc.get())) {
            continue;
          }
          paramRedTypeInfo = new JSONObject();
          if (!paramRedTypeInfo.has("dot")) {
            continue;
          }
          i = paramRedTypeInfo.getInt("dot");
        }
        catch (Exception paramRedTypeInfo)
        {
          int i = 0;
          QLog.e("RedTouchTextView", 1, "isSupportRedTouch json exception e = " + paramRedTypeInfo.getMessage());
          int j = i;
          continue;
          i = 0;
          continue;
        }
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RedTouchTextView", 2, "isSupportRedTouch had dot = " + i + ",path = " + paramAppInfo.path.get());
            j = i;
          }
          if (j == 1) {
            break;
          }
          return false;
        }
        catch (Exception paramRedTypeInfo) {}
      }
      paramRedTypeInfo = new JSONObject(paramRedTypeInfo.red_desc.get());
    }
  }
  
  private boolean auz()
  {
    if (this.c == null) {
      QLog.d("RedTouchTextView", 1, "isSupportRedTouch appinfo = null");
    }
    do
    {
      do
      {
        do
        {
          return false;
          if (this.c.iNewFlag.get() != 1)
          {
            QLog.d("RedTouchTextView", 1, "isSupportRedTouch inewflag = 0, path = " + this.c.path);
            return false;
          }
          localObject1 = (BusinessInfoCheckUpdate.RedDisplayInfo)this.c.red_display_info.get();
          if (localObject1 != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null, path = " + this.c.path.get());
        return false;
        localObject1 = ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject1).red_type_info.get();
        if (localObject1 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null, path = " + this.c.path.get());
      return false;
      if (((List)localObject1).size() >= 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos.size < 2, path = " + this.c.path.get());
    return false;
    Object localObject1 = new ArrayList((Collection)localObject1);
    int j = x((List)localObject1);
    Object localObject2 = ((List)localObject1).iterator();
    int i = 0;
    label270:
    if (((Iterator)localObject2).hasNext())
    {
      if (((BusinessInfoCheckUpdate.RedTypeInfo)((Iterator)localObject2).next()).red_type.get() == 9) {
        break label698;
      }
      i += 1;
    }
    label698:
    for (;;)
    {
      break label270;
      if (i == 0)
      {
        QLog.e("RedTouchTextView", 1, "isSupportRedTouch notSpaceInfoCount = 0");
        return false;
      }
      int i1 = In();
      int k = j;
      if ((k > i1) && (i > 1))
      {
        int n = ((List)localObject1).size();
        int m = 0;
        label354:
        k = n;
        j = i;
        if (m < n)
        {
          if (((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(m)).red_type.get() != 9)
          {
            ((List)localObject1).remove(m);
            j = i - 1;
            k = n - 1;
          }
        }
        else {
          i = 0;
        }
        for (;;)
        {
          if (i < k - 1)
          {
            if ((((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(i)).red_type.get() == 9) && (((BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(i + 1)).red_type.get() == 9)) {
              ((List)localObject1).remove(i);
            }
          }
          else
          {
            k = x((List)localObject1);
            i = j;
            break;
            m += 1;
            break label354;
          }
          i += 1;
        }
      }
      if ((k > i1) && (i == 1))
      {
        j = 0;
        while (j < ((List)localObject1).size())
        {
          localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(j);
          if ((((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() == 3) && (a((BusinessInfoCheckUpdate.RedTypeInfo)localObject2, this.c))) {
            setImageRedNotShowRedPoint((BusinessInfoCheckUpdate.RedTypeInfo)localObject2, this.c);
          }
          j += 1;
        }
      }
      if ((x((List)localObject1) > i1) && (i == 1))
      {
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject1).get(i);
          if ((((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() != 9) && (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() != 0))
          {
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
            ((List)localObject1).set(i, localObject2);
          }
          i += 1;
        }
      }
      if (x((List)localObject1) > i1) {
        break;
      }
      this.Fr = ((List)localObject1);
      return true;
    }
  }
  
  private void b(Canvas paramCanvas, int paramInt1, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, int paramInt2, JSONObject paramJSONObject)
    throws JSONException
  {
    float f1;
    float f2;
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouch text");
      }
      paramInt2 = -1;
      int i = 0;
      if (paramJSONObject.has("cr")) {
        paramInt2 = dO(paramJSONObject.getString("cr"));
      }
      if (paramJSONObject.has("cn")) {
        i = dO(paramJSONObject.getString("cn"));
      }
      paramRedTypeInfo = paramRedTypeInfo.red_content.get();
      paramJSONObject = new Paint(1);
      paramJSONObject.setTextSize(iJ(11));
      paramJSONObject.setTextAlign(Paint.Align.LEFT);
      int j = (int)paramJSONObject.measureText(paramRedTypeInfo);
      Object localObject = paramJSONObject.getFontMetrics();
      int k = (int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top);
      paramInt1 = getWidth() - iJ(0) - h(this.Fr, paramInt1);
      int m = getHeight() / 2 - k / 2 - iJ(2);
      Rect localRect = new Rect();
      localRect.left = paramInt1;
      localRect.top = m;
      localRect.right = (j + paramInt1);
      if (this.Fr.size() <= 2) {
        localRect.right += iJ(6) * 2;
      }
      localRect.bottom = (m + k + iJ(2) * 2);
      f1 = iJ(2) + m;
      f2 = ((Paint.FontMetrics)localObject).top;
      if (i != 0)
      {
        localObject = getResources().getDrawable(2130851404);
        ((Drawable)localObject).getBounds();
        ((Drawable)localObject).setBounds(paramInt1, m, localRect.right, localRect.bottom);
        ((Drawable)localObject).draw(paramCanvas);
      }
      paramJSONObject.setColor(paramInt2);
      if (this.Fr.size() > 2) {
        break label381;
      }
      paramInt1 = iJ(6) + paramInt1;
    }
    label381:
    for (;;)
    {
      paramCanvas.drawText(paramRedTypeInfo, paramInt1, f1 - f2, paramJSONObject);
      return;
    }
  }
  
  private void bf(Canvas paramCanvas)
  {
    if (auz())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "drawRed start draw");
      }
      if ((this.Fr == null) || (this.Fr.size() < 1)) {
        QLog.e("RedTouchTextView", 1, "drawRed showRedInfo = null");
      }
    }
    else
    {
      return;
    }
    int i = this.Fr.size() - 1;
    while (i >= 0)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)this.Fr.get(i);
      int j = localRedTypeInfo.red_type.get();
      try
      {
        if (TextUtils.isEmpty(localRedTypeInfo.red_desc.get())) {}
        for (JSONObject localJSONObject = new JSONObject();; localJSONObject = new JSONObject(localRedTypeInfo.red_desc.get()))
        {
          i(paramCanvas, i, j);
          b(paramCanvas, i, localRedTypeInfo, j, localJSONObject);
          a(paramCanvas, i, localRedTypeInfo, j, localJSONObject);
          break;
        }
      }
      catch (Exception localException)
      {
        QLog.e("RedTouchTextView", 1, "drawRed Exception " + localException);
        i -= 1;
      }
    }
  }
  
  private int h(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    boolean bool;
    if (paramList != null) {
      if (paramList.size() <= 2) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((paramList != null) && ((paramInt > paramList.size() - 1) || (paramInt < 0)))
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition error, size = " + paramList.size() + " position = " + paramInt);
          j = i;
        }
      }
      do
      {
        return j;
        bool = false;
        break;
        i = k;
        if (paramList != null)
        {
          i = k;
          if (paramList.size() > 0)
          {
            i = paramList.size() - 1;
            while (i >= paramInt)
            {
              j += a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i), bool);
              i -= 1;
            }
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition size = " + paramList.size());
              i = j;
            }
          }
        }
        j = i;
      } while (!QLog.isColorLevel());
      QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition width = " + i);
      return i;
      bool = false;
    }
  }
  
  private void i(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "draw redtouchpoint");
      }
      paramInt1 = getWidth() - h(this.Fr, paramInt1) - iJ(0);
      paramInt2 = getHeight() / 2 - this.dxr / 2;
      this.fs = getResources().getDrawable(2130851400);
      this.fs.setBounds(paramInt1, paramInt2, this.dxr + paramInt1, this.dxr + paramInt2);
      this.fs.draw(paramCanvas);
    }
  }
  
  private boolean l(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList1, List<BusinessInfoCheckUpdate.RedTypeInfo> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {}
    while ((paramList1.size() != paramList2.size()) || (paramList1.size() == 0)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label159;
      }
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo1 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList1.get(i);
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo2 = (BusinessInfoCheckUpdate.RedTypeInfo)paramList2.get(i);
      if ((localRedTypeInfo1.red_type.get() != localRedTypeInfo2.red_type.get()) || (!localRedTypeInfo1.red_content.get().equals(localRedTypeInfo2.red_content.get())) || (!localRedTypeInfo1.red_desc.get().equals(localRedTypeInfo2.red_desc.get())) || (localRedTypeInfo1.red_priority.get() != localRedTypeInfo2.red_priority.get())) {
        break;
      }
      i += 1;
    }
    label159:
    return true;
  }
  
  public static void setImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramRedTypeInfo == null) || (paramRedTypeInfo.red_type.get() != 3)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramRedTypeInfo.red_desc.get()))
        {
          localJSONObject = new JSONObject();
          if (localJSONObject.has("dot")) {
            localJSONObject.put("dot", 0);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RedTouchTextView", 2, "setImageRedNotShowRedPoint ,path = " + paramAppInfo.path.get());
          }
          paramRedTypeInfo.red_desc.set(localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramRedTypeInfo)
      {
        QLog.e("RedTouchTextView", 1, "setImageRedNotShowRedPoint json exception e = " + paramRedTypeInfo.getMessage());
        return;
      }
      JSONObject localJSONObject = new JSONObject(paramRedTypeInfo.red_desc.get());
    }
  }
  
  private int x(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    int j = 0;
    boolean bool;
    if (paramList != null) {
      if (paramList.size() <= 2) {
        bool = true;
      }
    }
    for (;;)
    {
      int i;
      if ((paramList != null) && (paramList.size() > 0))
      {
        i = 0;
        for (;;)
        {
          if (j < paramList.size())
          {
            int k = a((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(j), bool);
            j += 1;
            i = k + i;
            continue;
            bool = false;
            break;
          }
        }
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoList size = " + paramList.size());
        }
      }
      for (j = i;; j = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedTouchTextView", 2, "getWidthByRedInfoList width = " + j);
        }
        return j;
      }
      bool = false;
    }
  }
  
  protected Bitmap b(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = paramFile.getAbsolutePath();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = ((int)aqhu.getOptRatio(new BufferedInputStream(new FileInputStream(paramFile)), this.dxs, this.dxs));
      paramFile = SafeBitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramFile)), null, localOptions);
      return paramFile;
    }
    catch (Exception paramFile)
    {
      QLog.e("RedTouchTextView", 1, "getIconFromFile exception e = " + paramFile.getMessage());
      return null;
    }
    catch (Error paramFile)
    {
      QLog.e("RedTouchTextView", 1, "getIconFromFile error e = " + paramFile.getMessage());
    }
    return null;
  }
  
  public void dJJ()
  {
    if (this.mUiHandler == null) {
      this.mUiHandler = new Handler(Looper.getMainLooper());
    }
    this.mUiHandler.post(new RedTouchTextView.2(this));
  }
  
  protected int dO(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("#"))) {
      return 0;
    }
    return Color.parseColor(paramString);
  }
  
  protected int iJ(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    this.ft = paramDrawable;
    dJJ();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    bf(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RedTouchTextView", 2, "setAppInfo appInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedTouchTextView", 2, "setAppInfo path = " + paramAppInfo.path.get() + "; inewflag = " + paramAppInfo.iNewFlag.get());
    }
    if (!l(a(paramAppInfo), this.Fr))
    {
      this.fs = null;
      this.ft = null;
    }
    this.c = paramAppInfo;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTextView
 * JD-Core Version:    0.7.0.1
 */