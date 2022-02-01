package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.RemoteViews;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public class XGCustomPushNotificationBuilder
  extends XGPushNotificationBuilder
{
  private Integer B = null;
  private Integer C = null;
  private Integer D = null;
  private Integer E = null;
  private Integer F = null;
  private Integer G = null;
  private Integer H = null;
  private Bitmap I = null;
  
  protected void a(JSONObject paramJSONObject)
  {
    CommonHelper.jsonPut(paramJSONObject, "layoutId", this.B);
    CommonHelper.jsonPut(paramJSONObject, "layoutIconId", this.C);
    CommonHelper.jsonPut(paramJSONObject, "layoutTitleId", this.D);
    CommonHelper.jsonPut(paramJSONObject, "layoutTextId", this.E);
    CommonHelper.jsonPut(paramJSONObject, "layoutIconDrawableId", this.F);
    CommonHelper.jsonPut(paramJSONObject, "statusBarIconDrawableId", this.G);
    CommonHelper.jsonPut(paramJSONObject, "layoutTimeId", this.H);
  }
  
  protected void b(JSONObject paramJSONObject)
  {
    this.B = ((Integer)CommonHelper.jsonGet(paramJSONObject, "layoutId", null));
    this.C = ((Integer)CommonHelper.jsonGet(paramJSONObject, "layoutIconId", null));
    this.D = ((Integer)CommonHelper.jsonGet(paramJSONObject, "layoutTitleId", null));
    this.E = ((Integer)CommonHelper.jsonGet(paramJSONObject, "layoutTextId", null));
    this.F = ((Integer)CommonHelper.jsonGet(paramJSONObject, "layoutIconDrawableId", null));
    this.G = ((Integer)CommonHelper.jsonGet(paramJSONObject, "statusBarIconDrawableId", null));
    this.H = ((Integer)CommonHelper.jsonGet(paramJSONObject, "layoutTimeId", null));
  }
  
  public Pair<Notification, Object> buildNotification(Context paramContext)
  {
    if (this.B != null)
    {
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), this.B.intValue());
      if (this.D != null) {
        localRemoteViews.setTextViewText(this.D.intValue(), getTitle(paramContext));
      }
      if (this.E != null) {
        localRemoteViews.setTextViewText(this.E.intValue(), this.q);
      }
      if (this.C != null)
      {
        localRemoteViews.setImageViewResource(this.C.intValue(), this.F.intValue());
        if (this.I != null) {
          localRemoteViews.setImageViewBitmap(this.C.intValue(), this.I);
        }
      }
      if (this.G != null) {
        localRemoteViews.setTextViewText(this.G.intValue(), getTitle(paramContext));
      }
      if (this.H != null)
      {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
        Date localDate = new Date(System.currentTimeMillis());
        localRemoteViews.setTextViewText(this.H.intValue(), String.valueOf(localSimpleDateFormat.format(localDate)));
      }
      this.e = localRemoteViews;
      return a(paramContext);
    }
    return a(paramContext);
  }
  
  public int getLayoutIconDrawableId()
  {
    return this.F.intValue();
  }
  
  public Integer getLayoutIconId()
  {
    return this.C;
  }
  
  public int getLayoutId()
  {
    return this.B.intValue();
  }
  
  public int getLayoutTextId()
  {
    return this.E.intValue();
  }
  
  public int getLayoutTimeId()
  {
    return this.H.intValue();
  }
  
  public int getLayoutTitleId()
  {
    return this.D.intValue();
  }
  
  public String getType()
  {
    return "custom";
  }
  
  public XGCustomPushNotificationBuilder setLayoutIconDrawableBmp(Bitmap paramBitmap)
  {
    this.I = paramBitmap;
    return this;
  }
  
  public XGCustomPushNotificationBuilder setLayoutIconDrawableId(int paramInt)
  {
    this.F = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGCustomPushNotificationBuilder setLayoutIconId(int paramInt)
  {
    this.C = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGCustomPushNotificationBuilder setLayoutId(int paramInt)
  {
    this.B = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGCustomPushNotificationBuilder setLayoutTextId(int paramInt)
  {
    this.E = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGCustomPushNotificationBuilder setLayoutTimeId(int paramInt)
  {
    this.H = Integer.valueOf(paramInt);
    return this;
  }
  
  public XGCustomPushNotificationBuilder setLayoutTitleId(int paramInt)
  {
    this.D = Integer.valueOf(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGCustomPushNotificationBuilder
 * JD-Core Version:    0.7.0.1
 */