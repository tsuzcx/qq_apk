import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.lang.ref.WeakReference;
import java.util.List;

public class uwo
  implements AdapterView.c
{
  public uwo(EmosmActivity paramEmosmActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.this$0.aVT) {}
    label10:
    EmoticonPackage localEmoticonPackage;
    label244:
    do
    {
      int i;
      do
      {
        break label10;
        do
        {
          return;
        } while (this.this$0.progressDialog.isShowing());
        i = paramInt - this.this$0.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeaderViewsCount();
      } while (i < 0);
      localEmoticonPackage = (EmoticonPackage)this.this$0.jdField_a_of_type_Afie.getItem(i);
      if (this.this$0.aVU)
      {
        this.this$0.jdField_a_of_type_Afie.setSelected(i);
        this.this$0.jdField_a_of_type_Afie.notifyDataSetChanged();
        paramAdapterView = this.this$0.jdField_a_of_type_Afie.eJ();
        if ((paramAdapterView != null) && (paramAdapterView.size() > 0)) {
          this.this$0.W.setEnabled(true);
        }
        for (;;)
        {
          paramInt = 0;
          if (paramAdapterView != null) {
            paramInt = paramAdapterView.size();
          }
          this.this$0.setTitle(String.format(this.this$0.getResources().getString(2131693337), new Object[] { Integer.valueOf(paramInt) }));
          if (!this.this$0.jdField_a_of_type_Afie.ji(i)) {
            break;
          }
          if (this.this$0.mLaunchMode != 1) {
            break label244;
          }
          anot.a(this.this$0.app, "dc00898", "", "", "0X800AB11", "0X800AB11", 0, 0, "", "", "", "");
          return;
          this.this$0.W.setEnabled(false);
        }
        anot.a(this.this$0.app, "dc00898", "", "", "0X800AB17", "0X800AB17", 0, 0, "", "", "", "");
        return;
      }
    } while (!afgc.bk(this.this$0));
    this.this$0.aVT = true;
    paramAdapterView = localEmoticonPackage.epId;
    boolean bool1 = false;
    if (localEmoticonPackage.jobType == 2)
    {
      paramAdapterView = localEmoticonPackage.kinId;
      bool1 = true;
    }
    paramView = null;
    if (localEmoticonPackage.jobType == 4)
    {
      paramView = new Intent();
      paramView.putExtra("EXTRA_KEY_IS_SMALL_EMOTICON", true);
    }
    boolean bool2;
    if (localEmoticonPackage.jobType == 4)
    {
      bool2 = true;
      if (1 != this.this$0.getIntent().getExtras().getInt("emojimall_src", 3)) {
        break label494;
      }
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.this$0.mActivity.get(), this.this$0.app.getAccount(), 8, paramAdapterView, bool1, paramView, bool2);
    }
    for (;;)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "ep_mall", "Clk_ep_mine_detail", 0, 0, localEmoticonPackage.epId, "", "", "");
      if (this.this$0.mLaunchMode != 1) {
        break label530;
      }
      anot.a(this.this$0.app, "dc00898", "", "", "0X800AB0E", "0X800AB0E", 0, 0, "", "", "", "");
      return;
      bool2 = false;
      break;
      label494:
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.this$0.mActivity.get(), this.this$0.app.getAccount(), 4, paramAdapterView, bool1, paramView, bool2);
    }
    label530:
    anot.a(this.this$0.app, "dc00898", "", "", "0X800AB13", "0X800AB13", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwo
 * JD-Core Version:    0.7.0.1
 */