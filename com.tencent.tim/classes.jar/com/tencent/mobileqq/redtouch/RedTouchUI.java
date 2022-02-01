package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RedTouchUI
  extends RedTouch
{
  private List<RedTypeInfo> DY = new ArrayList();
  public RedAppInfo a;
  private int dxv = -1;
  private int dxw = -1;
  
  public RedTouchUI(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchUI(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  private boolean a(RedTypeInfo paramRedTypeInfo1, RedTypeInfo paramRedTypeInfo2)
  {
    if (paramRedTypeInfo1.getRed_type() != paramRedTypeInfo2.getRed_type()) {}
    while ((!paramRedTypeInfo1.getRed_content().equals(paramRedTypeInfo2.getRed_content())) || (!paramRedTypeInfo1.getRed_desc().equals(paramRedTypeInfo2.getRed_desc())) || (paramRedTypeInfo1.getRed_priority() != paramRedTypeInfo2.getRed_priority())) {
      return false;
    }
    return true;
  }
  
  private boolean as(List<RedTypeInfo> paramList)
  {
    if (this.DY.size() == 0) {}
    while (this.DY.size() != paramList.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.DY.size()) {
        break label84;
      }
      if (!a((RedTypeInfo)this.DY.get(i), (RedTypeInfo)paramList.get(i))) {
        break;
      }
      i += 1;
    }
    label84:
    return true;
  }
  
  private void b(RedTypeInfo paramRedTypeInfo)
  {
    int m = 0;
    int k = 0;
    if (paramRedTypeInfo == null) {}
    for (;;)
    {
      return;
      this.kc.setVisibility(0);
      try
      {
        Object localObject;
        if (TextUtils.isEmpty(paramRedTypeInfo.getRed_desc()))
        {
          localObject = new JSONObject();
          if (!((JSONObject)localObject).has("bg")) {
            break label400;
          }
        }
        label400:
        for (int i = dO(((JSONObject)localObject).getString("bg"));; i = 0) {
          switch (paramRedTypeInfo.getRed_type())
          {
          case 0: 
            paramRedTypeInfo = c(i);
            if (paramRedTypeInfo == null) {
              break;
            }
            i = this.redPointId;
            this.redPointId = (i + 1);
            paramRedTypeInfo.setId(i);
            this.kc.addView(paramRedTypeInfo);
            return;
            localObject = new JSONObject(paramRedTypeInfo.getRed_desc());
            break;
          case 3: 
            if (!((JSONObject)localObject).has("av")) {}
          case 4: 
          case 5: 
          case 9: 
            for (int j = ((JSONObject)localObject).getInt("av");; j = 0)
            {
              if (((JSONObject)localObject).has("dot")) {
                k = ((JSONObject)localObject).getInt("dot");
              }
              paramRedTypeInfo = a(paramRedTypeInfo.getRed_content(), j, k, i);
              if (paramRedTypeInfo == null) {
                break;
              }
              i = this.dnb;
              this.dnb = (i + 1);
              paramRedTypeInfo.setId(i);
              this.kc.addView(paramRedTypeInfo);
              return;
              j = -1;
              if (((JSONObject)localObject).has("cr")) {
                j = dO(((JSONObject)localObject).getString("cr"));
              }
              k = m;
              if (((JSONObject)localObject).has("cn")) {
                k = dO(((JSONObject)localObject).getString("cn"));
              }
              localObject = b(paramRedTypeInfo.getRed_content(), j, k, i);
              if (localObject == null) {
                break;
              }
              if (paramRedTypeInfo.getRed_type() == 4)
              {
                i = this.dnc;
                this.dnc = (i + 1);
              }
              for (;;)
              {
                ((View)localObject).setId(i);
                this.kc.addView((View)localObject);
                return;
                i = this.dnd;
                this.dnd = (i + 1);
              }
              paramRedTypeInfo = j(paramRedTypeInfo.getRed_content());
              if (paramRedTypeInfo == null) {
                break;
              }
              this.kc.addView(paramRedTypeInfo);
              return;
            }
          }
        }
        return;
      }
      catch (Exception paramRedTypeInfo) {}
    }
  }
  
  public View a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = new URLImageView(this.context);
    ((URLImageView)localObject).setScaleType(ImageView.ScaleType.FIT_XY);
    ((URLImageView)localObject).setBackgroundColor(paramInt3);
    a(paramString, (URLImageView)localObject, paramInt1);
    if (paramInt2 == 1)
    {
      if (this.dxv == -1) {
        throw new RuntimeException("must set the redpoint imageresource");
      }
      paramString = new FrameLayout(getContext());
      ((URLImageView)localObject).setLayoutParams(new FrameLayout.LayoutParams(iJ(36), iJ(36)));
      ((URLImageView)localObject).setPadding(iJ(3), iJ(3), iJ(3), iJ(3));
      paramString.addView((View)localObject);
      localObject = new ImageView(this.context);
      ((ImageView)localObject).setImageResource(this.dxv);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      ((ImageView)localObject).setLayoutParams(localLayoutParams);
      paramString.addView((View)localObject);
      paramString.setLayoutParams(c());
      return paramString;
    }
    paramString = c();
    paramString.width = iJ(36);
    paramString.height = iJ(36);
    ((URLImageView)localObject).setLayoutParams(paramString);
    ((URLImageView)localObject).setPadding(iJ(3), iJ(3), iJ(3), iJ(3));
    return localObject;
  }
  
  protected TextView b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.dxw == -1) {
      throw new RuntimeException("must set the redpoint imageresource");
    }
    TextView localTextView = new TextView(this.context);
    try
    {
      if (Integer.parseInt(paramString) > this.maxNum) {
        localTextView.setText(this.maxNum + "+");
      }
      for (;;)
      {
        localTextView.setTextColor(paramInt1);
        localTextView.setGravity(17);
        localTextView.setSingleLine(true);
        if (paramInt2 == 0) {
          break;
        }
        localTextView.setTextSize(11.0F);
        localTextView.setBackgroundResource(this.dxw);
        localTextView.setLayoutParams(c());
        if (this.czi)
        {
          localTextView.measure(0, 0);
          this.leftMargin = (localTextView.getMeasuredWidth() / 2);
          dJC();
        }
        return localTextView;
        localTextView.setText(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localTextView.setText(paramString);
        continue;
        localTextView.setTextSize(13.0F);
      }
    }
  }
  
  public void b(RedAppInfo paramRedAppInfo)
  {
    dGB();
    if (paramRedAppInfo == null) {}
    do
    {
      return;
      this.DY.clear();
    } while ((paramRedAppInfo.If() == 0) || (paramRedAppInfo.a() == null) || (paramRedAppInfo.a().fT() == null) || (as(paramRedAppInfo.a().fT())));
    this.DY.addAll(paramRedAppInfo.a().fT());
    Iterator localIterator = this.DY.iterator();
    while (localIterator.hasNext()) {
      b((RedTypeInfo)localIterator.next());
    }
    this.a = paramRedAppInfo;
  }
  
  protected ImageView c(int paramInt)
  {
    if (this.dxv == -1) {
      throw new RuntimeException("must set the redpoint imageresource");
    }
    ImageView localImageView = new ImageView(this.context);
    localImageView.setImageResource(this.dxv);
    localImageView.setBackgroundColor(paramInt);
    localImageView.setLayoutParams(c());
    return localImageView;
  }
  
  public void setRedpointImgResID(int paramInt)
  {
    this.dxv = paramInt;
  }
  
  public void setTextOrNumImgRedID(int paramInt)
  {
    this.dxw = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchUI
 * JD-Core Version:    0.7.0.1
 */