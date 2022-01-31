import android.os.Bundle;
import android.widget.Button;
import com.tencent.biz.troop.file.MoveFileActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class xaf
  extends xas
{
  public xaf(MoveFileActivity paramMoveFileActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, ByteStringMicro paramByteStringMicro, List<azpi> paramList, Bundle paramBundle)
  {
    this.a.a(true);
    if ((!paramBoolean1) || (paramList == null)) {
      return;
    }
    MoveFileActivity.a(this.a, paramInt3);
    MoveFileActivity.a(this.a, paramBoolean2);
    paramBoolean1 = paramBundle.getBoolean("isFirstPage");
    paramByteStringMicro = paramList.iterator();
    while (paramByteStringMicro.hasNext())
    {
      paramBundle = (azpi)paramByteStringMicro.next();
      if (MoveFileActivity.a(this.a).c.get(paramBundle.b) == null)
      {
        paramBundle.a = UUID.randomUUID();
        MoveFileActivity.a(this.a).c.put(paramBundle.b, paramBundle);
      }
    }
    if (paramBoolean1)
    {
      MoveFileActivity.a(this.a).clear();
      if (!MoveFileActivity.c(this.a).equals("/"))
      {
        paramByteStringMicro = new azpi();
        paramByteStringMicro.c = ajya.a(2131706909);
        paramByteStringMicro.b = "/";
        paramByteStringMicro.d = true;
        paramByteStringMicro.f = -1;
        MoveFileActivity.a(this.a).add(paramByteStringMicro);
      }
    }
    MoveFileActivity.b(this.a, paramInt1);
    if (!MoveFileActivity.c(this.a).equals("/"))
    {
      paramInt1 = paramList.size() - 1;
      if (paramInt1 >= 0)
      {
        if (!((azpi)paramList.get(paramInt1)).b.equals(MoveFileActivity.c(this.a))) {
          break label389;
        }
        if (MoveFileActivity.a(this.a) == -1)
        {
          MoveFileActivity.c(this.a, paramInt1 + MoveFileActivity.a(this.a).size() - 1);
          MoveFileActivity.a(this.a).setEnabled(true);
          MoveFileActivity.a(this.a).setBackgroundResource(2130839047);
          MoveFileActivity.a(this.a).setTextAppearance(this.a.getActivity(), 2131755329);
        }
      }
      MoveFileActivity.a(this.a).addAll(MoveFileActivity.a(this.a).size() - 1, paramList);
    }
    for (;;)
    {
      MoveFileActivity.a(this.a).notifyDataSetChanged();
      return;
      label389:
      paramInt1 -= 1;
      break;
      MoveFileActivity.a(this.a).addAll(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xaf
 * JD-Core Version:    0.7.0.1
 */