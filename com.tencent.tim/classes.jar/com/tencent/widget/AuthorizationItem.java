package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import atau.a;

public class AuthorizationItem
  extends LinearLayout
{
  public static final a a = new a("昵称  ", "key_authorize_user_name", 0);
  public static final a b = new a("手机号", "key_authorize_phone", 1);
  public static final a c = new a("省市区", "key_authorize_place", 2);
  public static final a d = new a("", "", -1);
  private a e;
  private int ess;
  private String mContent;
  
  public AuthorizationItem(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public AuthorizationItem(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  public AuthorizationItem(Context paramContext, String paramString, a parama, int paramInt)
  {
    super(paramContext);
    this.e = parama;
    this.ess = paramInt;
    this.mContent = paramString;
    init(paramContext, null);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131561232, this, true);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pF);
      this.ess = paramContext.getInteger(1, -1);
      this.e = a.a(paramContext.getInteger(2, -1));
      this.mContent = paramContext.getString(0);
      paramContext.recycle();
    }
    setPositionType(this.ess);
    setItemType(this.e);
    setContent(this.mContent);
  }
  
  public void setContent(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      ((TextView)findViewById(2131380767)).setText(paramString);
    }
  }
  
  public void setItemType(a parama)
  {
    ((TextView)findViewById(2131380769)).setText(parama.itemName);
  }
  
  public void setPositionType(int paramInt)
  {
    if (paramInt == 0) {
      setBackgroundResource(2130845819);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        setBackgroundResource(2130845818);
        return;
      }
      if (paramInt == 2)
      {
        setBackgroundResource(2130845816);
        return;
      }
    } while (paramInt != 3);
    setBackgroundResource(2130845815);
  }
  
  public static final class a
  {
    public final int est;
    public final String itemName;
    public final String key;
    
    a(String paramString1, String paramString2, int paramInt)
    {
      this.itemName = paramString1;
      this.key = paramString2;
      this.est = paramInt;
    }
    
    public static a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return AuthorizationItem.d;
      case 0: 
        return AuthorizationItem.a;
      case 1: 
        return AuthorizationItem.b;
      }
      return AuthorizationItem.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.AuthorizationItem
 * JD-Core Version:    0.7.0.1
 */