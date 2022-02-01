package com.tencent.mobileqq.vas.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import aqdj;
import aqdj.a;
import aqsf;
import aqsg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Collection;
import wja;

public class AvatarLayout
  extends FrameLayout
{
  private SparseArray<View> dN = new SparseArray();
  
  public AvatarLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AvatarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AvatarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ListView paramListView, Collection<String> paramCollection)
  {
    if (paramListView == null) {
      return;
    }
    int i = 0;
    label7:
    Object localObject;
    BaseBubbleBuilder.e locale;
    ChatMessage localChatMessage;
    if (i < paramListView.getChildCount())
    {
      localObject = paramListView.getChildAt(i);
      if ((localObject != null) && ((localObject instanceof BaseChatItemLayout)))
      {
        locale = (BaseBubbleBuilder.e)wja.a((View)localObject);
        localChatMessage = wja.a((View)localObject);
        if ((locale != null) && (localChatMessage != null) && (localChatMessage.senderuin != null) && (paramCollection.contains(localChatMessage.senderuin)))
        {
          if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004)) {
            break label186;
          }
          localObject = localChatMessage.frienduin;
          label124:
          if ((localChatMessage.istroop != 1010) && (localChatMessage.istroop != 1001) && (localChatMessage.istroop != 10002)) {
            break label196;
          }
          localObject = aqdj.a(paramQQAppInterface, 200, (String)localObject, true);
        }
      }
    }
    for (;;)
    {
      locale.a.setHeaderIcon(localObject);
      i += 1;
      break label7;
      break;
      label186:
      localObject = localChatMessage.senderuin;
      break label124;
      label196:
      aqdj localaqdj = aqdj.a(paramQQAppInterface, 1, (String)localObject);
      localObject = new aqsg((String)localObject, -1, "small", localChatMessage.uniseq);
      ((aqsg)localObject).dQ = localaqdj;
    }
  }
  
  private void efm()
  {
    removeAllViews();
    int i = 0;
    while (i < 2)
    {
      View localView = (View)this.dN.get(i);
      if (localView != null) {
        addView(localView, -1, -1);
      }
      i += 1;
    }
  }
  
  public View Q(int paramInt)
  {
    return (View)this.dN.get(paramInt);
  }
  
  public void XU(int paramInt)
  {
    if ((View)this.dN.get(paramInt) != null)
    {
      this.dN.remove(paramInt);
      efm();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ImageView.ScaleType paramScaleType)
  {
    VasAvatar localVasAvatar2 = (VasAvatar)Q(1);
    VasAvatar localVasAvatar1 = localVasAvatar2;
    if (localVasAvatar2 == null)
    {
      localVasAvatar1 = new VasAvatar(getContext());
      c(1, localVasAvatar1, true);
    }
    localVasAvatar1.setLoader(this, new aqsg(paramInt1, paramInt2, paramString, false));
    localVasAvatar1.setScaleType(paramScaleType);
    localVasAvatar1.setVisibility(0);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ImageView.ScaleType paramScaleType)
  {
    VasAvatar localVasAvatar = (VasAvatar)Q(1);
    if (localVasAvatar == null)
    {
      localVasAvatar = new VasAvatar(getContext());
      c(1, localVasAvatar, true);
    }
    for (;;)
    {
      localVasAvatar.setLoader(this, new aqsg(paramString1, paramInt, paramString2, 0L));
      localVasAvatar.setScaleType(paramScaleType);
      localVasAvatar.setVisibility(0);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, boolean paramBoolean)
  {
    this.dN.put(paramInt, paramView);
    if (paramBoolean) {
      efm();
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, aqdj.a parama, int paramInt4, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt5)
  {
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)Q(0);
    localDynamicAvatarView.setFaceDrawable(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramInt4, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, aqsf.kt(paramInt5));
    if (VasAvatar.bv(paramInt1, paramInt2)) {
      a(paramString, paramInt5, VasAvatar.gl(paramInt4), localDynamicAvatarView.getScaleType());
    }
    for (;;)
    {
      localDynamicAvatarView.setVisibility(0);
      return;
      XU(1);
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt3)
  {
    Drawable localDrawable = aqdj.g(paramInt1, 1);
    setFaceDrawable(paramAppInterface, paramInt1, 200, paramString, (byte)0, 1, false, localDrawable, localDrawable, null, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt3);
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean1, DynamicAvatar paramDynamicAvatar, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt4)
  {
    DynamicAvatarView localDynamicAvatarView = (DynamicAvatarView)Q(0);
    localDynamicAvatarView.setFaceDrawable(paramAppInterface, paramDrawable, paramInt1, paramInt2, paramString, paramInt3, paramBoolean1, paramDynamicAvatar, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, aqsf.kt(paramInt4));
    if (VasAvatar.bv(paramInt1, paramInt2)) {
      a(paramString, paramInt4, VasAvatar.gl(paramInt3), localDynamicAvatarView.getScaleType());
    }
    for (;;)
    {
      localDynamicAvatarView.setVisibility(0);
      return;
      XU(1);
    }
  }
  
  public void setFaceDrawable(AppInterface paramAppInterface, Drawable paramDrawable, int paramInt1, String paramString, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    setFaceDrawable(paramAppInterface, paramDrawable, paramInt1, 200, paramString, paramInt2, paramBoolean1, null, false, paramBoolean2, false, false, paramInt3);
  }
  
  public void setGoneBelow(int paramInt)
  {
    int j = this.dN.size();
    int i = 0;
    if (i < j)
    {
      int k = this.dN.keyAt(i);
      if (k < paramInt)
      {
        View localView = (View)this.dN.valueAt(i);
        if (localView == null) {
          break label63;
        }
        localView.setVisibility(8);
      }
      for (;;)
      {
        i += 1;
        break;
        label63:
        QLog.e("AvatarLayout", 1, "null avatar at " + k);
      }
    }
  }
  
  public void setStaticAvatar(Bitmap paramBitmap)
  {
    ImageView localImageView = (ImageView)Q(0);
    localImageView.setImageBitmap(paramBitmap);
    localImageView.setVisibility(0);
    XU(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.AvatarLayout
 * JD-Core Version:    0.7.0.1
 */