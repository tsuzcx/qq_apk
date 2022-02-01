import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ashc
  implements View.OnClickListener
{
  private long Gh;
  
  public ashc(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.Gh) >= 1000L)
      {
        this.Gh = l;
        Object localObject1 = (albb)paramView.getTag();
        Object localObject2;
        switch (((albb)localObject1).nType)
        {
        default: 
          break;
        case 4: 
          this.this$0.XP(String.valueOf(((albb)localObject1).data));
          break;
        case 7: 
          this.this$0.bGM();
          break;
        case 20: 
          anot.b(this.this$0.app, "dc00899", "Qidian", "", "0X8008FEB", "qidianMasterVideo", 1, 1, 0, "1", "1", "", "");
          if (this.this$0.accountType == 6) {
            ChatActivityUtils.a(this.this$0.app, this.this$0, 1024, this.this$0.jdField_a_of_type_Alcn.e.uin, this.this$0.b.nickname, null, true, null, true, true, null, "from_internal");
          } else {
            FriendProfileCardActivity.a(this.this$0.app, this.this$0, this.this$0.jdField_a_of_type_Alcn);
          }
          break;
        case 55: 
          this.this$0.eny();
          break;
        case 8: 
          this.this$0.Zx(((Integer)((albb)localObject1).data).intValue());
          break;
        case 52: 
          this.this$0.XO(String.valueOf(((albb)localObject1).data));
          break;
        case 47: 
          this.this$0.XT(String.valueOf(((albb)localObject1).data));
          break;
        case 48: 
          localObject2 = (String[])((albb)localObject1).data;
          localObject1 = localObject2[0];
          localObject2 = localObject2[1];
          this.this$0.iO((String)localObject1, (String)localObject2);
          break;
        case 49: 
          this.this$0.XQ(String.valueOf(((albb)localObject1).data));
          break;
        case 50: 
          this.this$0.a((asic)((albb)localObject1).data);
          break;
        case 51: 
          this.this$0.XS(String.valueOf(((albb)localObject1).data));
          break;
        case 53: 
          this.this$0.enx();
          break;
        case 54: 
          localObject1 = aqik.c(this.this$0.app, this.this$0, String.valueOf(((albb)localObject1).data));
          if (localObject1 != null) {
            ((aqhv)localObject1).ace();
          }
          break;
        case 75: 
          QidianProfileCardActivity.a(this.this$0, String.valueOf(((albb)localObject1).data));
          break;
        case 76: 
          localObject1 = String.valueOf(((albb)localObject1).data);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("|")))
          {
            localObject1 = ((String)localObject1).split("\\|");
            if ((localObject1 != null) && (localObject1.length == 2)) {
              QidianProfileCardActivity.a(this.this$0, localObject1[0], localObject1[1]);
            }
          }
          break;
        case 82: 
          if (!QidianProfileCardActivity.b(this.this$0))
          {
            QidianProfileCardActivity.b(this.this$0, true);
            if ((this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.d != null))
            {
              this.this$0.bT(this.this$0.jdField_a_of_type_Alcn.d.vQzoneCoverInfo);
            }
            else
            {
              this.this$0.showLoading(2131697483);
              localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppCardHandler;
              localObject2 = this.this$0.app.getCurrentAccountUin();
              String str = this.this$0.jdField_a_of_type_Alcn.e.uin;
              l = ProfileActivity.a(this.this$0.jdField_a_of_type_Alcn.e, false);
              ((CardHandler)localObject1).a((String)localObject2, str, 1, 0L, (byte)1, 0L, 0L, new byte[] { 0 }, "", l, 10004, new byte[] { 0 }, (byte)0);
            }
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ashc
 * JD-Core Version:    0.7.0.1
 */