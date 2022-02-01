import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileListFragment;
import com.tencent.tim.teamwork.PadInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class atfr
  extends aulm
{
  public atfr(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, int paramInt4, List<PadInfo> paramList)
  {
    super.a(paramBoolean1, paramInt1, paramInt2, paramBoolean2, paramBoolean3, paramInt3, paramInt4, paramList);
    paramList = (atgc)CloudFileListFragment.l(this.this$0).getManager(373);
    if ((paramList != null) && (CloudFileListFragment.a(this.this$0) != null) && (Arrays.equals(CloudFileListFragment.a(this.this$0).Y(), paramList.aE())))
    {
      QLog.i("CloudFileListFragment", 1, "isSuccess = " + paramBoolean1 + ",typePadList: " + paramInt1 + ",retCode: " + paramInt2 + ",isTimeStampChanged: " + paramBoolean2 + ",isEnd: " + paramBoolean3 + ",totalCount: " + paramInt3 + ",typeOperation: " + paramInt4);
      paramList = CloudFileListFragment.a(this.this$0).iterator();
      while (paramList.hasNext())
      {
        atiu localatiu = (atiu)paramList.next();
        aull localaull = (aull)CloudFileListFragment.m(this.this$0).getManager(372);
        if (((localatiu instanceof atin)) && (((atin)localatiu).name.equals(this.this$0.getString(2131691584))) && (localaull.hp().size() > 0) && (CloudFileListFragment.a(this.this$0) != null))
        {
          ((atin)localatiu).sortTime = ((PadInfo)localaull.hp().get(0)).getSortTime();
          CloudFileListFragment.a(this.this$0).notifyDataSetChanged();
        }
      }
    }
  }
  
  public void bX(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {
      this.this$0.uiHandler.sendEmptyMessageDelayed(115, 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfr
 * JD-Core Version:    0.7.0.1
 */