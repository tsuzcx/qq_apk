package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import acfp;
import aihz;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import aqnm;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqinterface.NewMiniAioInterface;
import com.tencent.widget.immersive.ImmersiveUtils;
import wiy;

public class GroupMiniAioInterfaceImpl
  implements NewMiniAioInterface
{
  private Activity mActivity;
  private aihz mMiniMsgUser;
  private long roomId;
  private int roomType;
  private int xPoint;
  private int yPoint;
  
  Intent getBackIntent()
  {
    Intent localIntent1 = new Intent();
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("tab_index", MainFragment.bIk);
    localIntent1.putExtra("fragment_id", 1);
    localIntent1.putExtra("banner_wording", acfp.m(2131707030));
    localIntent1.putExtra("banner_iconIdx", 13);
    localIntent1.putExtra("banner_iconIdx", 14);
    localIntent1.putExtra("banner_businessCategory", "GroupVideo");
    localIntent1.putExtra("banner_activityName", JumpActivity.class);
    localIntent1.putExtra("banner_plguinType", 1);
    localIntent1.putExtra("banner_pluginProxyActivityName", this.mActivity.getClass().getName());
    Intent localIntent2 = new Intent(this.mActivity, JumpActivity.class);
    localIntent2.setData(Uri.parse(String.format("nowmqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%d&fromid=10001&roomtype=%d", new Object[] { Long.valueOf(this.roomId), Integer.valueOf(this.roomType) })));
    localIntent2.addFlags(268435456);
    localIntent1.putExtra("banner_pendingIntent", PendingIntent.getActivities(this.mActivity, 0, new Intent[] { localIntent2 }, 134217728));
    return localIntent1;
  }
  
  protected MiniMsgUserParam getMiniMsgUserParam()
  {
    int i = this.mActivity.getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    int k = this.mActivity.getApplication().getResources().getDimensionPixelSize(2131297713);
    if (this.xPoint == 0)
    {
      i = i - k * 4 - aqnm.dpToPx(35.0F);
      if (this.yPoint != 0) {
        break label147;
      }
      j += aqnm.dip2px(7.0F);
    }
    for (;;)
    {
      MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
      localMiniMsgUserParam.businessName = 26;
      localMiniMsgUserParam.accessType = 0;
      localMiniMsgUserParam.entryType = 1;
      localMiniMsgUserParam.positionX = i;
      localMiniMsgUserParam.positionY = j;
      localMiniMsgUserParam.colorType = 1;
      localMiniMsgUserParam.filterMsgType = 1;
      localMiniMsgUserParam.backConversationIntent = getBackIntent();
      return localMiniMsgUserParam;
      i = this.xPoint;
      break;
      label147:
      j += this.yPoint;
    }
  }
  
  public void onBackground()
  {
    this.mMiniMsgUser.onBackground();
  }
  
  public void onCreate(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    
    if (TextUtils.isEmpty(paramString1)) {}
    this.mActivity = ((Activity)((ContextWrapper)paramContext).getBaseContext());
    this.roomId = paramLong;
    this.roomType = paramInt;
    this.mMiniMsgUser = new aihz(this.mActivity, paramString1, paramString2, getMiniMsgUserParam());
    ThreadManagerV2.getUIHandlerV2().post(new GroupMiniAioInterfaceImpl.1(this));
  }
  
  public void onDestroy()
  {
    this.mMiniMsgUser.destroy();
  }
  
  public void onForeground()
  {
    this.mMiniMsgUser.onForeground();
  }
  
  public void setPoint(int paramInt1, int paramInt2)
  {
    this.xPoint = paramInt1;
    this.yPoint = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.GroupMiniAioInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */