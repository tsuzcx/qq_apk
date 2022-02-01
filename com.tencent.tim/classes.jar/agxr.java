import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class agxr
  extends ahda
{
  private TextView SB;
  private TextView SC;
  private String bJv;
  private int cYR;
  private boolean cfK;
  private View.OnClickListener fc = new agxs(this);
  
  public agxr(QQAppInterface paramQQAppInterface, Context paramContext, QFileSendBottomView paramQFileSendBottomView)
  {
    super(paramQQAppInterface, paramContext, paramQFileSendBottomView);
    initView();
  }
  
  private void dkp()
  {
    if ((this.be == null) || (!this.be.containsKey("qfile_search_param_exparams_qlink_state")))
    {
      ds(null);
      return;
    }
    Object localObject1 = this.bJv;
    Object localObject2 = agmz.D();
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((Set)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      localArrayList.add(((FileInfo)((Iterator)localObject2).next()).getPath());
    }
    int i = this.be.getInt("qfile_search_param_exparams_qlink_state");
    localObject2 = new Intent();
    if (222 == i)
    {
      ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
      i = -1;
    }
    for (;;)
    {
      J(i, (Intent)localObject2);
      return;
      if ((333 == i) || (666 == i) || (3333 == i) || (6666 == i))
      {
        ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
      }
      else
      {
        if ((444 == i) || (555 == i))
        {
          if (444 == i) {}
          for (boolean bool = true;; bool = false)
          {
            ((Intent)localObject2).putExtra("_INIT_SEND_IOS_", bool);
            ((Intent)localObject2).putExtra("string_filepaths", localArrayList);
            break;
          }
        }
        if ((777 == i) || (888 == i))
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putStringArrayList("string_filepaths", localArrayList);
          this.mApp.a();
          avhc.c(this.mContext, 16, (Bundle)localObject1);
          i = -1;
        }
        else
        {
          this.mApp.a().g((String)localObject1, localArrayList);
          ((Intent)localObject2).putExtra("_UIN_", (String)localObject1);
          ((Intent)localObject2).putExtra("_SEND_QLINK_FILE_", true);
          i = -1;
        }
      }
    }
  }
  
  private void initView()
  {
    this.SB = ((TextView)this.a.M(2131377979));
    this.SC = ((TextView)this.a.M(2131372449));
    this.SB.setOnClickListener(this.fc);
  }
  
  public void cD(Bundle paramBundle)
  {
    super.cD(paramBundle);
    if (this.cgf)
    {
      this.bJv = this.be.getString("qfile_search_param_ex_params_target_uin");
      this.cYR = this.be.getInt("qfile_search_param_exparams_qlink_state");
      this.cfK = this.be.getBoolean("qfile_search_param_exparams_qlink_ap_created");
    }
  }
  
  public void dko()
  {
    this.SC.setText(2131700498);
    this.SB.setText(acfp.m(2131714264));
    TextView localTextView = this.SB;
    if (agmz.fN() > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localTextView.setEnabled(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxr
 * JD-Core Version:    0.7.0.1
 */