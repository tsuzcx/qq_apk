import android.os.Bundle;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.biz.troop.file.MoveFileActivity.a;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class sml
  extends smq.e
{
  public sml(MoveFileActivity paramMoveFileActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, ByteStringMicro paramByteStringMicro, List<apbr> paramList, Bundle paramBundle)
  {
    this.this$0.tG(true);
    if ((!paramBoolean1) || (paramList == null)) {
      return;
    }
    MoveFileActivity.a(this.this$0, paramInt3);
    MoveFileActivity.a(this.this$0, paramBoolean2);
    paramBoolean1 = paramBundle.getBoolean("isFirstPage");
    paramByteStringMicro = paramList.iterator();
    while (paramByteStringMicro.hasNext())
    {
      paramBundle = (apbr)paramByteStringMicro.next();
      if (MoveFileActivity.a(this.this$0).nO.get(paramBundle.mFileId) == null)
      {
        paramBundle.Id = UUID.randomUUID();
        MoveFileActivity.a(this.this$0).nO.put(paramBundle.mFileId, paramBundle);
      }
    }
    if (paramBoolean1)
    {
      MoveFileActivity.a(this.this$0).clear();
      if (!MoveFileActivity.c(this.this$0).equals("/"))
      {
        paramByteStringMicro = new apbr();
        paramByteStringMicro.str_file_name = acfp.m(2131708475);
        paramByteStringMicro.mFileId = "/";
        paramByteStringMicro.cPN = true;
        paramByteStringMicro.ErrorCode = -1;
        MoveFileActivity.a(this.this$0).add(paramByteStringMicro);
      }
    }
    MoveFileActivity.b(this.this$0, paramInt1);
    if (!MoveFileActivity.c(this.this$0).equals("/"))
    {
      paramInt1 = paramList.size() - 1;
      if (paramInt1 >= 0)
      {
        if (!((apbr)paramList.get(paramInt1)).mFileId.equals(MoveFileActivity.c(this.this$0))) {
          break label389;
        }
        if (MoveFileActivity.a(this.this$0) == -1)
        {
          MoveFileActivity.c(this.this$0, paramInt1 + MoveFileActivity.a(this.this$0).size() - 1);
          MoveFileActivity.a(this.this$0).setEnabled(true);
          MoveFileActivity.a(this.this$0).setBackgroundResource(2130839545);
          MoveFileActivity.a(this.this$0).setTextAppearance(this.this$0.getActivity(), 2131755587);
        }
      }
      MoveFileActivity.a(this.this$0).addAll(MoveFileActivity.a(this.this$0).size() - 1, paramList);
    }
    for (;;)
    {
      MoveFileActivity.a(this.this$0).notifyDataSetChanged();
      return;
      label389:
      paramInt1 -= 1;
      break;
      MoveFileActivity.a(this.this$0).addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sml
 * JD-Core Version:    0.7.0.1
 */