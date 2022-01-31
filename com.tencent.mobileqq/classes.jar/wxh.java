import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wxh
  extends wwc
{
  public SparseArray<uti> a;
  
  public wxh(@NonNull wwe paramwwe)
  {
    super(paramwwe);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
  }
  
  @NonNull
  private List<Long> a(@NonNull List<String> paramList)
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
        wsv.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
      }
    }
    return localArrayList;
  }
  
  private void f()
  {
    Activity localActivity = a().getActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, ShareToActivity.class);
      uti localuti = (uti)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Wwe.a());
      if (!uti.a(localuti)) {
        localIntent.putStringArrayListExtra("share_to_group_key", new ArrayList(localuti.a));
      }
      localActivity.startActivityForResult(localIntent, 5555);
    }
  }
  
  private void g()
  {
    wti localwti = (wti)super.a(wti.class);
    if (uti.a((uti)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Wwe.a())))
    {
      localwti.b(2130846313);
      return;
    }
    localwti.b(2130846314);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 5555)
    {
      if (paramInt2 == 1)
      {
        paramIntent = paramIntent.getStringArrayListExtra("share_to_group_key");
        if (paramIntent != null) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Wwe.a(), new uti(paramIntent));
        }
      }
      this.jdField_a_of_type_Wwe.a(0);
      g();
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    f();
  }
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    super.a(paramInt, paramxgs);
    ??? = (uti)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (uti.a((uti)???)) {}
    for (;;)
    {
      return;
      List localList = a(((uti)???).a);
      if (localList.size() > 0) {}
      synchronized (this.jdField_a_of_type_Wwe)
      {
        qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        byte[] arrayOfByte = paramxgs.a.spreadGroupBytes;
        if (arrayOfByte != null) {}
        try
        {
          localVideoSpreadGroupList.mergeFrom(paramxgs.a.spreadGroupBytes);
          localVideoSpreadGroupList.group_list.set(localList);
          localVideoSpreadGroupList.visibility_type.set(2);
          localVideoSpreadGroupList.setHasFlag(true);
          paramxgs.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
          wsv.d("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish fragment index = %d, qq-group count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localList.size()) });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + paramxgs.a.spreadGroupBytes);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            wsv.c("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
          }
        }
      }
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxh
 * JD-Core Version:    0.7.0.1
 */