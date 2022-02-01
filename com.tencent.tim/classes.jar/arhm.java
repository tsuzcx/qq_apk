import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NowShowVideoInfo;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.data.QZonePhotoInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.ProfileCardNewPhotoWallView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedList;

public class arhm
  implements View.OnClickListener
{
  public arhm(ProfileCardNewPhotoWallView paramProfileCardNewPhotoWallView, ProfilePhotoWall paramProfilePhotoWall, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if ((this.a instanceof NowShowVideoInfo))
    {
      localObject1 = (NowShowVideoInfo)this.a;
      localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("url", ((NowShowVideoInfo)localObject1).mJumpUrl);
      paramView.getContext().startActivity((Intent)localObject2);
      anot.a(this.b.mApp, "dc00899", "NOW", "", "qq_zlk", "replay_click", 0, 0, this.b.mUin, "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = new Intent(this.b.mActivity, TroopAvatarWallPreviewActivity.class);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("index", this.val$pos);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = 0;
      while (i < this.b.ar.size())
      {
        Object localObject3 = (ProfilePhotoWall)this.b.ar.get(i);
        if ((localObject3 instanceof QZonePhotoInfo))
        {
          localArrayList1.add(((ProfilePhotoWall)localObject3).getOriginUrl());
          localObject3 = (QZonePhotoInfo)localObject3;
          localArrayList2.add(((QZonePhotoInfo)localObject3).photoId);
          localArrayList3.add(((QZonePhotoInfo)localObject3).time + "");
        }
        i += 1;
      }
      ((Bundle)localObject2).putStringArrayList("seqNum", localArrayList1);
      ((Bundle)localObject2).putBoolean("from_photo_wall", true);
      if (this.b.mApp.getCurrentAccountUin().equals(this.b.mUin))
      {
        ((Bundle)localObject2).putBoolean("delete_ability", true);
        ((Bundle)localObject2).putStringArrayList("photoIds", localArrayList2);
        ((Bundle)localObject2).putStringArrayList("photoTimes", localArrayList3);
      }
      ((Bundle)localObject2).putBoolean("SHOW_MENU", true);
      ((Bundle)localObject2).putBoolean("IS_EDIT", false);
      ((Bundle)localObject2).putBoolean("is_use_path", true);
      ((Bundle)localObject2).putBoolean("is_show_action", true);
      ((Bundle)localObject2).putBoolean("is_not_show_index", true);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      this.b.mActivity.startActivity((Intent)localObject1);
      if (this.b.mApp.getCurrentAccountUin().equals(this.b.mUin)) {
        anot.a(this.b.mApp, "CliOper", "", "", "0X8006A80", "0X8006A80", 0, 0, "", "", "", "");
      } else {
        anot.a(this.b.mApp, "CliOper", "", "", "0X8006A94", "0X8006A94", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhm
 * JD-Core Version:    0.7.0.1
 */