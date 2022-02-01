import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;

public class yin
  implements View.OnClickListener, yjf
{
  private TextView KM;
  private oidb_cmd0xb36.ToastInfo a;
  private String aWf;
  private Activity mActivity;
  private QQAppInterface mApp;
  private SessionInfo mSessionInfo;
  private List<ImageView> sH = new ArrayList();
  private ImageView ui;
  private View xJ;
  
  public yin(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramActivity;
    this.mSessionInfo = paramSessionInfo;
    this.aWf = paramString;
  }
  
  public int[] E()
  {
    return null;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.mActivity).inflate(2131560757, null);
    this.KM = ((TextView)paramVarArgs.findViewById(2131379710));
    this.ui = ((ImageView)paramVarArgs.findViewById(2131368698));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131363176));
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131363178));
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131363180));
    this.sH = localArrayList;
    paramVarArgs.setOnClickListener(this);
    this.xJ = paramVarArgs;
    return paramVarArgs;
  }
  
  public void a(TroopManager paramTroopManager, yjh paramyjh, TroopMemberInfo paramTroopMemberInfo)
  {
    paramTroopManager = paramTroopManager.a(this.mSessionInfo.aTl);
    if ((paramTroopManager == null) || ((paramTroopMemberInfo != null) && ((paramTroopMemberInfo.level == 332) || (paramTroopMemberInfo.level == 333))))
    {
      if (paramyjh.wN() == 20) {
        paramyjh.ciA();
      }
      this.a = null;
    }
    do
    {
      return;
      this.a = paramTroopManager;
    } while ((!paramyjh.a(this, new Object[0])) || (this.xJ == null));
    if (this.a.type.has())
    {
      paramTroopManager = String.format(Locale.getDefault(), "https://pub.idqqimg.com/pc/misc/group_chain/aio_icon_%d.png", new Object[] { Integer.valueOf(this.a.type.get()) });
      paramyjh = URLDrawable.URLDrawableOptions.obtain();
      paramyjh.mRequestWidth = riw.dip2px(this.mActivity, 32.0F);
      paramyjh.mRequestHeight = paramyjh.mRequestWidth;
      paramTroopManager = URLDrawable.getDrawable(paramTroopManager, paramyjh);
      this.ui.setImageDrawable(paramTroopManager);
    }
    this.KM.setText(this.a.wording.get());
    paramTroopMemberInfo = new ArrayList(this.sH);
    List localList;
    int i;
    if (this.a.uins.has())
    {
      localList = this.a.uins.get();
      i = 0;
      if ((i < localList.size()) && (i < paramTroopMemberInfo.size())) {}
    }
    else
    {
      paramTroopManager = paramTroopMemberInfo.iterator();
    }
    while (paramTroopManager.hasNext())
    {
      paramyjh = (ImageView)paramTroopManager.next();
      if (paramyjh != null)
      {
        paramyjh.setVisibility(8);
        continue;
        ImageView localImageView = (ImageView)paramTroopMemberInfo.get(i);
        localImageView.setVisibility(0);
        paramTroopManager = aqhu.at();
        paramyjh = aqdj.a(qem.getQQAppInterface(), 1, String.valueOf(localList.get(i)), 3, paramTroopManager, paramTroopManager);
        if (paramyjh == null) {}
        for (;;)
        {
          localImageView.setImageDrawable(paramTroopManager);
          paramTroopMemberInfo.set(i, null);
          i += 1;
          break;
          paramTroopManager = paramyjh;
        }
      }
    }
    if (this.a.type.get() != 1) {}
    for (paramTroopManager = "1";; paramTroopManager = "2")
    {
      paramyjh = ((TroopManager)this.mApp.getManager(52)).c(this.mSessionInfo.aTl);
      aqfr.b("Grp_edu", "Grp_chain", "ChainBanner_Show", 0, 0, new String[] { this.mSessionInfo.aTl, paramTroopManager, "", String.valueOf(paramyjh.dwGroupClassExt) });
      return;
    }
  }
  
  public void a(yjh paramyjh)
  {
    TroopManager localTroopManager = (TroopManager)this.mApp.getManager(52);
    localTroopManager.a(this.mSessionInfo.aTl, this.mApp.getCurrentAccountUin(), new yio(this, localTroopManager, paramyjh));
  }
  
  public int getType()
  {
    return 20;
  }
  
  public void h(int paramInt, Object... paramVarArgs) {}
  
  public void onClick(View paramView)
  {
    if (this.a == null)
    {
      QLog.e(".troop.survey", 1, "toast info empty , click error!");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = new Intent(this.mActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.a.link.get());
    this.mActivity.startActivity((Intent)localObject);
    if (this.a.type.get() != 1) {}
    for (localObject = "1";; localObject = "2")
    {
      TroopInfo localTroopInfo = ((TroopManager)this.mApp.getManager(52)).c(this.mSessionInfo.aTl);
      aqfr.b("Grp_edu", "Grp_chain", "ChainBanner_Clk", 0, 0, new String[] { this.mSessionInfo.aTl, localObject, "", String.valueOf(localTroopInfo.dwGroupClassExt) });
      break;
    }
  }
  
  public int wM()
  {
    return 59;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yin
 * JD-Core Version:    0.7.0.1
 */