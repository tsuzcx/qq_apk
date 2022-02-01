import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPermission.1;
import com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rdk
  extends rdb
  implements rdl
{
  private RedDotImageView a;
  private boolean aHf;
  private boolean aHg;
  private Handler bo = new Handler(Looper.getMainLooper());
  private int bqs = 10000;
  private int bqt = 10000;
  private Runnable cT = new EditVideoPermission.1(this);
  private ArrayList<String> kN = new ArrayList();
  private String mCurrentUin;
  private TextView yp;
  
  public rdk(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  @NonNull
  private List<Long> aw(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localArrayList.add(Long.valueOf(Long.valueOf(str).longValue()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ram.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
      }
    }
    return localArrayList;
  }
  
  private void btg()
  {
    Activity localActivity = a().getActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, PermissionSettingActivity.class);
      localIntent.putExtra("PERMISSION_TYPE_KEY", this.bqt);
      localIntent.putStringArrayListExtra("PERMISSION_UIN_LIST_KEY", this.kN);
      localActivity.startActivityForResult(localIntent, 1);
      this.aHg = true;
      this.bo.postDelayed(this.cT, 1000L);
    }
  }
  
  private void bth()
  {
    switch (this.bqt)
    {
    default: 
      this.yp.setText(getString(2131701758));
      return;
    case 10004: 
      this.yp.setText(getString(2131701766));
      return;
    case 10000: 
      this.yp.setText(getString(2131701758));
      return;
    case 10001: 
      this.yp.setText(getString(2131701762));
      return;
    }
    this.yp.setText(getString(2131701767));
  }
  
  private int tn()
  {
    int i = ((Integer)((psr)psx.a(10)).c("key_last_used_permission", Integer.valueOf(10000))).intValue();
    ram.b("Q.qqstory.publish.edit.EditVideoPermission", "get default permission from local. type is %d.", Integer.valueOf(i));
    return i;
  }
  
  private void xb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 1;
    }
    for (;;)
    {
      rar.a("pub_control", "clk_change", 0, 0, new String[] { String.valueOf(paramInt) });
      return;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
    }
  }
  
  private void xc(int paramInt)
  {
    int i = 3;
    switch (paramInt)
    {
    default: 
      ram.e("Q.qqstory.publish.edit.EditVideoPermission", "unKnown type:%s", new Object[] { Integer.valueOf(paramInt) });
      paramInt = 1;
      switch (this.b.a.th())
      {
      case 2: 
      default: 
        ram.e("Q.qqstory.publish.edit.EditVideoPermission", "unKnown entrance:%s", new Object[] { Integer.valueOf(this.b.a.th()) });
        i = 99;
      }
      break;
    }
    for (;;)
    {
      ram.b("Q.qqstory.publish.edit.EditVideoPermission", "report select permission, permissionType:%s, entranceType:%s", Integer.valueOf(paramInt), Integer.valueOf(i));
      rar.a("pub_control", "clk_done", 0, 0, new String[] { String.valueOf(i), String.valueOf(paramInt) });
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      paramInt = 4;
      break;
      paramInt = 5;
      break;
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    super.a(paramInt, paramrkm);
    ram.d("Q.qqstory.publish.edit.EditVideoPermission", "EditVideoPermission editVideoPrePublish....");
    Object localObject = new ArrayList();
    int i;
    switch (this.bqt)
    {
    default: 
      i = 0;
    }
    try
    {
      for (;;)
      {
        long l = Long.valueOf(this.mCurrentUin).longValue();
        if (((List)localObject).contains(Long.valueOf(l))) {
          ((List)localObject).remove(Long.valueOf(l));
        }
        ram.d("Q.qqstory.publish.edit.EditVideoPermission", "permissionType:" + i);
        ram.d("Q.qqstory.publish.edit.EditVideoPermission", "permissionUinList:" + localObject.toString());
        qqstory_struct.VideoReaderConf localVideoReaderConf = new qqstory_struct.VideoReaderConf();
        localVideoReaderConf.ban_type.set(i);
        localVideoReaderConf.user_list.set((List)localObject);
        localVideoReaderConf.setHasFlag(true);
        paramrkm.g.readerConfBytes = localVideoReaderConf.toByteArray();
        if ((paramInt == 0) && (this.bqt != this.bqs))
        {
          ram.d("Q.qqstory.publish.edit.EditVideoPermission", "user has changed permission during editing session. default permission is %d, new permission is %d.", Integer.valueOf(this.bqs), Integer.valueOf(this.bqt));
          xb(this.bqt);
        }
        return;
        i = 1000;
        continue;
        i = 0;
        continue;
        i = 1;
        continue;
        i = 2;
        localObject = aw(this.kN);
        continue;
        i = 3;
        localObject = aw(this.kN);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.publish.edit.EditVideoPermission", "MyUin , can't format uin:%s", new Object[] { this.mCurrentUin });
      }
    }
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    super.d(paramInt1, paramInt2, paramObject);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str;
    Object localObject;
    if (paramInt1 == 1) {
      if ((paramInt2 == 1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("PERMISSION_TYPE_KEY", -2147483648);
        str = paramIntent.getStringExtra("PERMISSION_CURRENT_UIN_KEY");
        localObject = null;
        switch (paramInt1)
        {
        }
      }
    }
    for (paramIntent = localObject;; paramIntent = paramIntent.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY"))
    {
      this.bqt = paramInt1;
      this.mCurrentUin = str;
      this.kN.clear();
      if (paramIntent != null) {
        this.kN.addAll(paramIntent);
      }
      xc(paramInt1);
      bth();
      this.b.changeState(0);
      return;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.yp = ((TextView)y(2131372992));
    this.a = ((RedDotImageView)y(2131373000));
    this.bqs = tn();
    this.bqt = this.bqs;
    bth();
    this.a.setVisibility(8);
    a(rdl.class, this);
  }
  
  public void onStop()
  {
    ram.d("Q.qqstory.publish.edit.EditVideoPermission", "onStop, set jump flag false.");
    this.aHg = false;
    this.bo.removeCallbacks(this.cT);
    super.onStop();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    int i = 1;
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.aHf) {}
    for (paramInt = i;; paramInt = 2)
    {
      rar.a("pub_control", "clk_entry", 0, 0, new String[] { String.valueOf(paramInt) });
      btg();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdk
 * JD-Core Version:    0.7.0.1
 */