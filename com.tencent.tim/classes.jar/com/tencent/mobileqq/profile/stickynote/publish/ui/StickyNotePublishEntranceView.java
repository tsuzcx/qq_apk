package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import anot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import org.json.JSONObject;
import spp;

public class StickyNotePublishEntranceView
  extends FrameLayout
{
  private TextView Xh;
  private Card a;
  private URLImageView aO;
  private URLImageView bA;
  private int bFk = 1;
  private String bWh;
  private String bWi;
  private Drawable fn;
  private Drawable fo;
  private ViewGroup mContentLayout;
  private boolean xv;
  
  public StickyNotePublishEntranceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StickyNotePublishEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  protected void bs(JSONObject paramJSONObject)
  {
    String str;
    Object localObject;
    if ((this.a != null) && (paramJSONObject != null))
    {
      if (!this.xv) {
        break label102;
      }
      str = "host";
      localObject = paramJSONObject.optJSONObject(str);
      if (localObject != null)
      {
        paramJSONObject = ((JSONObject)localObject).optString("leftIcon");
        str = ((JSONObject)localObject).optString("bgUrl");
        localObject = ((JSONObject)localObject).optString("summary");
        if (TextUtils.isEmpty(paramJSONObject)) {
          break label108;
        }
        this.bA.setBackgroundURL(paramJSONObject);
        label67:
        if (TextUtils.isEmpty(str)) {
          break label120;
        }
        this.aO.setBackgroundURL(str);
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label134;
      }
      this.Xh.setText(mL((String)localObject));
      return;
      label102:
      str = "guest";
      break;
      label108:
      this.bA.setVisibility(8);
      break label67;
      label120:
      this.aO.setBackgroundDrawable(this.fn);
    }
    label134:
    this.Xh.setVisibility(8);
  }
  
  protected void dFw()
  {
    this.bA.setImageResource(2130846768);
    if (this.xv) {}
    for (String str = this.bWh;; str = this.bWi)
    {
      this.Xh.setText(mL(str));
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break;
      }
      this.bA.setColorFilter(1996488704);
      this.aO.setBackgroundDrawable(this.fo);
      return;
    }
    this.aO.setBackgroundDrawable(this.fn);
  }
  
  protected void initView(Context paramContext)
  {
    inflate(paramContext, 2131561619, this);
    this.mContentLayout = ((ViewGroup)findViewById(2131365382));
    this.bA = ((URLImageView)findViewById(2131370347));
    this.aO = ((URLImageView)findViewById(2131363237));
    this.Xh = ((TextView)findViewById(2131379010));
    paramContext = paramContext.getResources();
    this.fn = new ColorDrawable(paramContext.getColor(2131166719));
    this.fo = new ColorDrawable(paramContext.getColor(2131166720));
    this.bWh = paramContext.getString(2131692199);
    this.bWi = paramContext.getString(2131692198);
    updateUI();
  }
  
  protected String mL(String paramString)
  {
    Object localObject = paramString;
    Card localCard;
    if (!TextUtils.isEmpty(paramString))
    {
      localCard = this.a;
      localObject = paramString;
      if (localCard != null)
      {
        localObject = getContext().getResources();
        if (localCard.shGender != 0) {
          break label52;
        }
        localObject = ((Resources)localObject).getString(2131694580);
      }
    }
    for (;;)
    {
      localObject = paramString.replace("{TA}", (CharSequence)localObject);
      return localObject;
      label52:
      if (localCard.shGender == 1) {
        localObject = ((Resources)localObject).getString(2131720203);
      } else {
        localObject = ((Resources)localObject).getString(2131720724);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mContentLayout.setAlpha(0.5F);
      continue;
      this.mContentLayout.setAlpha(1.0F);
      if (this.xv)
      {
        anot.a(null, "dc00898", "", "", "0X800AB1F", "0X800AB1F", this.bFk, 0, "0", "0", "", "");
      }
      else
      {
        anot.a(null, "dc00898", "", "", "0X800AB20", "0X800AB20", this.bFk, 0, "0", "0", "", "");
        continue;
        this.mContentLayout.setAlpha(1.0F);
      }
    }
  }
  
  public void setIsHost(boolean paramBoolean)
  {
    this.xv = paramBoolean;
  }
  
  public void updateFriendProfileCard(Card paramCard)
  {
    this.a = paramCard;
    updateUI();
  }
  
  public void updateUI()
  {
    Object localObject = (String)spp.a().getValue("sticky_note_publish_entrance_config", "");
    int i;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      dFw();
      i = 1;
    }
    for (;;)
    {
      this.bFk = i;
      if (this.xv)
      {
        anot.a(null, "dc00898", "", "", "0X800AB1D", "0X800AB1D", i, 0, "0", "0", "", "");
        return;
      }
      for (;;)
      {
        try
        {
          JSONObject localJSONObject3 = new JSONObject((String)localObject);
          JSONObject localJSONObject2 = localJSONObject3.optJSONObject("festival");
          if (localJSONObject2 == null) {
            break label427;
          }
          bool1 = "1".equals(localJSONObject2.optString("enable"));
          i = localJSONObject2.optInt("priority");
          JSONObject localJSONObject1 = null;
          boolean bool3 = false;
          int k = 2;
          Card localCard = this.a;
          int j = k;
          boolean bool2 = bool3;
          localObject = localJSONObject1;
          if (localCard != null)
          {
            int m = (int)((localCard.lBirthday & 0xFF00) >> 8);
            int n = (int)(localCard.lBirthday & 0xFF);
            localObject = Calendar.getInstance();
            ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
            int i1 = ((Calendar)localObject).get(2);
            int i2 = ((Calendar)localObject).get(5);
            j = k;
            bool2 = bool3;
            localObject = localJSONObject1;
            if (m == i1 + 1)
            {
              j = k;
              bool2 = bool3;
              localObject = localJSONObject1;
              if (n == i2)
              {
                localJSONObject1 = localJSONObject3.optJSONObject("birthday");
                j = k;
                bool2 = bool3;
                localObject = localJSONObject1;
                if (localJSONObject1 != null)
                {
                  bool2 = "1".equals(localJSONObject1.optString("enable"));
                  j = localJSONObject1.optInt("priority");
                  localObject = localJSONObject1;
                }
              }
            }
          }
          if ((bool1) && (bool2))
          {
            if ((bool2) && (j >= i))
            {
              bs((JSONObject)localObject);
              i = 3;
            }
            else
            {
              bs(localJSONObject2);
              i = 4;
            }
          }
          else if ((bool2) && (!bool1))
          {
            bs((JSONObject)localObject);
            i = 3;
          }
          else if ((bool1) && (!bool2))
          {
            bs(localJSONObject2);
            i = 4;
          }
          else
          {
            dFw();
            i = 1;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("StickyNotePublishEntranceView", 2, localThrowable, new Object[0]);
          i = 1;
        }
        break;
        anot.a(null, "dc00898", "", "", "0X800AB1E", "0X800AB1E", i, 0, "0", "0", "", "");
        return;
        label427:
        i = 1;
        boolean bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishEntranceView
 * JD-Core Version:    0.7.0.1
 */