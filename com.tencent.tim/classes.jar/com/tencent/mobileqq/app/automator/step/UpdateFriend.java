package com.tencent.mobileqq.app.automator.step;

import acfd;
import acff;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

public class UpdateFriend
  extends AsyncStep
{
  private acfd l;
  
  private void cNK()
  {
    if (this.l == null)
    {
      this.l = new a(null);
      this.a.app.addObserver(this.l);
    }
    ((FriendListHandler)this.a.app.getBusinessHandler(1)).IY(0);
  }
  
  private void cNL()
  {
    if (this.l == null)
    {
      this.l = new a(null);
      this.a.app.addObserver(this.l);
    }
    ((FriendListHandler)this.a.app.getBusinessHandler(1)).EQ(true);
  }
  
  public int od()
  {
    if (this.cyx == 3)
    {
      boolean bool = this.a.O.getBoolean("isFriendlistok", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "doStep PREF_ISFRIENDLIST_OK=" + bool);
      }
      acff localacff = (acff)this.a.app.getManager(51);
      if (bool)
      {
        FriendListHandler localFriendListHandler = (FriendListHandler)this.a.app.getBusinessHandler(1);
        bool = localacff.aac();
        localacff.cJa();
        localFriendListHandler.notifyUI(1, bool, Boolean.valueOf(bool));
        this.a.notifyUI(3, true, Integer.valueOf(1));
        return 7;
      }
      localacff.aac();
      localacff.cJa();
      cNL();
      return 2;
    }
    if (this.cyx == 7)
    {
      cNL();
      return 2;
    }
    cNK();
    return 2;
  }
  
  public void onCreate()
  {
    if (this.cyx == 3) {
      ((PhoneContactManagerImp)this.a.app.getManager(11)).clI();
    }
    if (this.cyx == 8) {}
    for (int i = 0;; i = 2)
    {
      this.cyy = i;
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.l != null)
    {
      this.a.app.removeObserver(this.l);
      this.l = null;
    }
  }
  
  class a
    extends acfd
  {
    private a() {}
    
    public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((UpdateFriend.this.cyx == 7) || (UpdateFriend.this.cyx == 3))
      {
        if (paramBoolean1) {
          break label37;
        }
        UpdateFriend.this.setResult(6);
      }
      label37:
      while ((!paramBoolean1) || (!paramBoolean2)) {
        return;
      }
      UpdateFriend.this.a.O.edit().putBoolean("isFriendlistok", true).commit();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onUpdateFriendList put PREF_ISFRIENDLIST_OK true");
      }
      UpdateFriend.this.a.notifyUI(3, true, Integer.valueOf(1));
      UpdateFriend.this.setResult(7);
    }
    
    public void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (UpdateFriend.this.cyx == 8)
      {
        if (paramBoolean1) {
          break label26;
        }
        UpdateFriend.this.setResult(6);
      }
      label26:
      while (!paramBoolean2) {
        return;
      }
      UpdateFriend.this.setResult(7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend
 * JD-Core Version:    0.7.0.1
 */