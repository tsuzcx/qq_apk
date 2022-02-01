package com.tencent.mobileqq.gamecenter.view;

import ahuh;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.qphone.base.util.QLog;

public class GameArkView
  extends RelativeLayout
  implements ahuh
{
  private ArkView a;
  
  public GameArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(2131559378, this);
    this.a = ((ArkView)findViewById(2131375047));
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity) {}
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    if (this.a != null) {
      this.a.load(paramQQGameMsgInfo.arkAppName, paramQQGameMsgInfo.arkAppView, paramQQGameMsgInfo.arkAppMinVersion, paramQQGameMsgInfo.arkMetaList, paramQQGameMsgInfo.arkAppConfig, null);
    }
  }
  
  public void destory()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameArkView", 1, "GameArkView onPause");
      }
      this.a.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameArkView", 1, "GameArkView onResume");
      }
      this.a.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameArkView
 * JD-Core Version:    0.7.0.1
 */