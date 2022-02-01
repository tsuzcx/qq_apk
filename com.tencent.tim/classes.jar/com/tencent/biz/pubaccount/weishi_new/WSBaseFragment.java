package com.tencent.biz.pubaccount.weishi_new;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import oer;
import oes;
import oet;
import oeu;
import ofd;

public abstract class WSBaseFragment<V extends oer, P extends oeu<V>>
  extends PublicBaseFragment
  implements oer, oes<V, P>
{
  private oet<V, P> a;
  protected P a;
  private MiniMsgUser mMiniMsgUser;
  private boolean mShowOnFirst;
  
  protected boolean GG()
  {
    return false;
  }
  
  public V a()
  {
    return this;
  }
  
  @NonNull
  protected oet<V, P> a()
  {
    if (this.jdField_a_of_type_Oet == null) {
      this.jdField_a_of_type_Oet = new ofd(this);
    }
    return this.jdField_a_of_type_Oet;
  }
  
  public void a(P paramP)
  {
    this.jdField_a_of_type_Oeu = paramP;
  }
  
  public P b()
  {
    return this.jdField_a_of_type_Oeu;
  }
  
  protected void bdX() {}
  
  public MiniMsgUser getMiniMsgUser()
  {
    return this.mMiniMsgUser;
  }
  
  protected MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 6;
    localMiniMsgUserParam.accessType = 2;
    localMiniMsgUserParam.filterMsgType = 0;
    localMiniMsgUserParam.entryType = 0;
    localMiniMsgUserParam.positionX = -1;
    localMiniMsgUserParam.positionY = -1;
    localMiniMsgUserParam.colorType = 0;
    return localMiniMsgUserParam;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a().onCreate(paramBundle);
    if (GG())
    {
      paramBundle = getMiniMsgUserParam();
      this.mMiniMsgUser = new MiniMsgUser(getActivity(), paramBundle);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a().onDestroy();
    if ((GG()) && (this.mMiniMsgUser != null)) {
      this.mMiniMsgUser.destroy();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    a().onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    if ((GG()) && (this.mMiniMsgUser != null)) {
      this.mMiniMsgUser.onBackground();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((GG()) && (this.mMiniMsgUser != null)) {
      this.mMiniMsgUser.onForeground();
    }
    bdX();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a().onViewCreated(paramView, paramBundle);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.mShowOnFirst))
    {
      if ((GG()) && (this.mMiniMsgUser != null)) {
        this.mMiniMsgUser.showOnFirst();
      }
      this.mShowOnFirst = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseFragment
 * JD-Core Version:    0.7.0.1
 */