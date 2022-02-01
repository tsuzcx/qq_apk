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

public class yyw
  extends yxr
{
  public SparseArray<wuy> a;
  
  public yyw(@NonNull yxt paramyxt)
  {
    super(paramyxt);
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
        yuk.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
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
      wuy localwuy = (wuy)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Yxt.a());
      if (!wuy.a(localwuy)) {
        localIntent.putStringArrayListExtra("share_to_group_key", new ArrayList(localwuy.a));
      }
      localActivity.startActivityForResult(localIntent, 5555);
    }
  }
  
  private void g()
  {
    yux localyux = (yux)super.a(yux.class);
    if (wuy.a((wuy)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Yxt.a())))
    {
      localyux.b(2130846841);
      return;
    }
    localyux.b(2130846842);
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
          this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Yxt.a(), new wuy(paramIntent));
        }
      }
      this.jdField_a_of_type_Yxt.a(0);
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
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    super.a(paramInt, paramzih);
    ??? = (wuy)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (wuy.a((wuy)???)) {}
    for (;;)
    {
      return;
      List localList = a(((wuy)???).a);
      if (localList.size() > 0) {}
      synchronized (this.jdField_a_of_type_Yxt)
      {
        qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        byte[] arrayOfByte = paramzih.a.spreadGroupBytes;
        if (arrayOfByte != null) {}
        try
        {
          localVideoSpreadGroupList.mergeFrom(paramzih.a.spreadGroupBytes);
          localVideoSpreadGroupList.group_list.set(localList);
          localVideoSpreadGroupList.visibility_type.set(2);
          localVideoSpreadGroupList.setHasFlag(true);
          paramzih.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
          yuk.d("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish fragment index = %d, qq-group count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localList.size()) });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + paramzih.a.spreadGroupBytes);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            yuk.c("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyw
 * JD-Core Version:    0.7.0.1
 */