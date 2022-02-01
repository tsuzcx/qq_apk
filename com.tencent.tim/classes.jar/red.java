import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class red
  extends rdb
{
  private boolean aCI;
  private String axW;
  private int bly;
  private int boj;
  private long groupUin;
  private String shareGroupId;
  private TextView ys;
  
  public red(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    if (this.shareGroupId != null) {}
    synchronized (this.b)
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      byte[] arrayOfByte = paramrkm.g.spreadGroupBytes;
      if (arrayOfByte != null) {}
      try
      {
        localVideoSpreadGroupList.mergeFrom(paramrkm.g.spreadGroupBytes);
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(this.shareGroupId));
        localVideoSpreadGroupList.visibility_sharegroup_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
        paramrkm.g.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
        if (this.boj == 1) {
          paramrkm.g.putExtra("groupUin", Long.valueOf(this.groupUin));
        }
        ram.w("EditVideoShareGroup", "editVideoPrePublish fragment index = %d, share-group %s %s %s %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.boj), this.shareGroupId, this.axW, Long.valueOf(this.groupUin) });
        paramrkm.g.putExtra("ignorePersonalPublish", Boolean.valueOf(this.aCI));
        paramrkm.g.putExtra("add_video_source", Integer.valueOf(this.bly));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          ram.e("EditVideoShareGroup", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.shareGroupId = this.b.a.getStringExtra("shareGroupId");
    this.axW = this.b.a.getStringExtra("shareGroupName");
    this.boj = this.b.a.getIntExtra("shareGroupType", 0);
    this.groupUin = this.b.a.getLongExtra("groupUin", -1L);
    this.aCI = this.b.a.getBooleanExtra("ignorePersonalPublish", false);
    this.bly = this.b.a.getIntExtra("add_video_source", 0);
    ram.a("EditVideoShareGroup", "shareGroupId=%s, shareGroupName=%s, ignorePersonalPublish=%s, source=%d", this.shareGroupId, this.axW, Boolean.valueOf(this.aCI), Integer.valueOf(this.bly));
    this.ys = ((TextView)y(2131378170));
    this.ys.setVisibility(0);
    this.ys.setText(this.axW);
    this.ys.setOnClickListener(new ree(this));
    if (this.shareGroupId == null)
    {
      ram.e("EditVideoShareGroup", "shareGroupId should not be null");
      a().a(0, null, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     red
 * JD-Core Version:    0.7.0.1
 */