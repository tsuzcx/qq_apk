import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.ImageButton;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Iterator;
import java.util.List;

public class ayhi
  extends aygy
{
  private boolean aHf;
  private ImageButton aQ;
  private int bqs;
  private int bqt;
  private ArrayList<String> kN = new ArrayList();
  private String mCurrentUin;
  
  public ayhi(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  public static void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString, ArrayList<String> paramArrayList, List<String> paramList)
  {
    if (paramList.contains(paramString)) {
      paramList.remove(paramString);
    }
    Object localObject = new ArrayList();
    switch (paramInt)
    {
    default: 
      paramArrayList = (ArrayList<String>)localObject;
      paramInt = 0;
    }
    try
    {
      for (;;)
      {
        long l = Long.valueOf(paramString).longValue();
        if (paramArrayList.contains(Long.valueOf(l))) {
          paramArrayList.remove(Long.valueOf(l));
        }
        ram.d("Q.qqstory.publish.edit.EditVideoPermission", "permissionType:" + paramInt);
        ram.d("Q.qqstory.publish.edit.EditVideoPermission", "permissionUinList:" + paramArrayList.toString());
        ram.d("Q.qqstory.publish.edit.EditVideoPermission", "atUinList:" + paramList.toString());
        paramString = new qqstory_struct.VideoReaderConf();
        paramString.ban_type.set(paramInt);
        paramString.user_list.set(paramArrayList);
        paramString.setHasFlag(true);
        paramPublishVideoEntry.readerConfBytes = paramString.toByteArray();
        return;
        paramInt = 1000;
        paramArrayList = (ArrayList<String>)localObject;
        continue;
        paramArrayList = (ArrayList<String>)localObject;
        paramInt = 0;
        continue;
        String str;
        if (!paramList.isEmpty())
        {
          paramArrayList = paramList.iterator();
          while (paramArrayList.hasNext())
          {
            str = (String)paramArrayList.next();
            try
            {
              ((List)localObject).add(Long.valueOf(Long.valueOf(str).longValue()));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              ram.e("Q.qqstory.publish.edit.EditVideoPermission", "PERMISSION_TYPE_ONLY_ME , can't format uin:%s", new Object[] { str });
            }
          }
          paramArrayList = (ArrayList<String>)localObject;
          paramInt = 2;
        }
        else
        {
          paramArrayList = (ArrayList<String>)localObject;
          paramInt = 1;
          continue;
          paramArrayList = aw(paramArrayList);
          localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            try
            {
              l = Long.valueOf(str).longValue();
              if (!paramArrayList.contains(Long.valueOf(l))) {
                paramArrayList.add(Long.valueOf(l));
              }
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              ram.e("Q.qqstory.publish.edit.EditVideoPermission", "PERMISSION_TYPE_CAN_SEE , can't format uin:%s", new Object[] { str });
            }
          }
          paramInt = 2;
          continue;
          paramArrayList = aw(paramArrayList);
          localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            try
            {
              l = Long.valueOf(str).longValue();
              if (paramArrayList.contains(Long.valueOf(l))) {
                paramArrayList.remove(Long.valueOf(l));
              }
            }
            catch (NumberFormatException localNumberFormatException4)
            {
              ram.e("Q.qqstory.publish.edit.EditVideoPermission", "PERMISSION_TYPE_CANNOT_SEE , can't format uin:%s", new Object[] { str });
            }
          }
          paramInt = 3;
        }
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      for (;;)
      {
        ram.e("Q.qqstory.publish.edit.EditVideoPermission", "MyUin , can't format uin:%s", new Object[] { paramString });
      }
    }
  }
  
  @NonNull
  private static List<Long> aw(@NonNull List<String> paramList)
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
    }
  }
  
  private void bth()
  {
    switch (this.bqt)
    {
    default: 
      this.aQ.setImageResource(2130847571);
      return;
    case 10004: 
      this.aQ.setImageResource(2130847575);
      return;
    case 10000: 
      this.aQ.setImageResource(2130847571);
      return;
    case 10001: 
      this.aQ.setImageResource(2130847581);
      return;
    }
    this.aQ.setImageResource(2130847579);
  }
  
  private int tn()
  {
    return 10000;
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
      i = 1;
      continue;
      i = 2;
    }
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    super.a(paramInt, paramayqb);
    ram.d("Q.qqstory.publish.edit.EditVideoPermission", "EditVideoPermission editVideoPrePublish....");
    ArrayList localArrayList = new ArrayList();
    ayfg localayfg = (ayfg)a(ayfg.class);
    if (localayfg != null) {
      localArrayList.addAll(localayfg.au(paramInt));
    }
    a(paramayqb.g, this.bqt, this.mCurrentUin, this.kN, localArrayList);
    if ((paramInt == 0) && (this.bqt != this.bqs))
    {
      ram.d("Q.qqstory.publish.edit.EditVideoPermission", "user has changed permission during editing session. default permission is %d, new permission is %d.", Integer.valueOf(this.bqs), Integer.valueOf(this.bqt));
      xb(this.bqt);
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
    this.aQ = ((ImageButton)y(2131372995));
    this.bqs = tn();
    this.bqt = this.bqs;
    bth();
  }
  
  public void p(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (this.aHf) {}
    for (paramInt = 1;; paramInt = 2)
    {
      rar.a("pub_control", "clk_entry", 0, 0, new String[] { String.valueOf(paramInt) });
      if (this.aHf)
      {
        this.aHf = false;
        ((psr)psx.a(10)).n("key_has_show_publish_permission_red_dot", Boolean.valueOf(true));
        rar.a("pub_control", "clk_buble_guide", 0, 0, new String[0]);
      }
      btg();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhi
 * JD-Core Version:    0.7.0.1
 */