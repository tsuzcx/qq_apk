import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchRspBody.Item;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FileInfo;

public class apcs
{
  public ArrayList<String> BP;
  public long aqV;
  public apbr b;
  public String cok;
  public String col;
  public String com;
  public long groupCode;
  public String groupName;
  public long uploaderUin;
  
  public apcs(QQAppInterface paramQQAppInterface, cmd0x383.ApplyFileSearchRspBody.Item paramItem)
  {
    if (paramItem == null) {
      return;
    }
    this.groupCode = paramItem.uint64_group_code.get();
    this.groupName = paramItem.bytes_group_name.get().toStringUtf8();
    this.uploaderUin = paramItem.uint64_upload_uin.get();
    this.cok = paramItem.bytes_uploader_nick_name.get().toStringUtf8();
    this.BP = new ArrayList();
    List localList = paramItem.bytes_match_word.get();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        this.BP.add(((ByteStringMicro)localList.get(i)).toStringUtf8());
        i += 1;
      }
    }
    this.aqV = paramItem.uint64_match_uin.get();
    if (this.aqV > 0L)
    {
      paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).e(String.valueOf(this.aqV));
      if (paramQQAppInterface != null)
      {
        this.col = paramQQAppInterface.name;
        this.com = paramQQAppInterface.remark;
      }
    }
    this.b = new apbr((cmd0x383.ApplyGetFileListRspBody.FileInfo)paramItem.file_info.get());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("groupCode = " + this.groupCode);
    localStringBuilder.append(", groupName = " + this.groupName);
    localStringBuilder.append(", uploaderUin = " + this.uploaderUin);
    localStringBuilder.append(", uploaderNickName = " + this.cok);
    localStringBuilder.append(", matchUin = " + this.aqV);
    if (this.BP != null)
    {
      localStringBuilder.append(", matchWord: = ");
      int j = this.BP.size();
      int i = 0;
      if (i < j)
      {
        if (i == j - 1) {
          localStringBuilder.append((String)this.BP.get(i) + ", ");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append((String)this.BP.get(i)).append("、 ");
        }
      }
    }
    if (this.b != null) {
      localStringBuilder.append(", fileInfo = " + this.b.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apcs
 * JD-Core Version:    0.7.0.1
 */