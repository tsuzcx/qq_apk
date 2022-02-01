import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tim.cloudfile.CloudFileListFragment;
import com.tencent.tim.filemanager.widget.CloudSendBottomBar;
import java.util.ArrayList;

public class atga
  implements atdt.a
{
  public atga(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void Vu(boolean paramBoolean)
  {
    TextView localTextView;
    if (CloudFileListFragment.b(this.this$0))
    {
      CloudFileListFragment.b(this.this$0, paramBoolean);
      localTextView = this.this$0.leftView;
      if (!paramBoolean) {
        break label47;
      }
    }
    label47:
    for (String str = this.this$0.getString(2131691566);; str = this.this$0.getString(2131691565))
    {
      localTextView.setText(str);
      return;
    }
  }
  
  public void etm()
  {
    if (CloudFileListFragment.a(this.this$0) != null) {
      CloudFileListFragment.a(this.this$0).dmH();
    }
    int i;
    int j;
    int k;
    if (CloudFileListFragment.b(this.this$0))
    {
      this.this$0.setTitle(String.format("已选 %d 项", new Object[] { Integer.valueOf(atiz.Ou()) }));
      i = atiz.el().size();
      j = atiz.em().size();
      k = atiz.en().size();
      if ((j <= 0) && (i + k != 0)) {
        break label128;
      }
      CloudFileListFragment.a(this.this$0).setEnabled(false);
    }
    while (i + j + k > 0)
    {
      CloudFileListFragment.a(this.this$0).setEnabled(true);
      CloudFileListFragment.b(this.this$0).setEnabled(true);
      return;
      label128:
      CloudFileListFragment.a(this.this$0).setEnabled(true);
    }
    CloudFileListFragment.a(this.this$0).setEnabled(false);
    CloudFileListFragment.b(this.this$0).setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atga
 * JD-Core Version:    0.7.0.1
 */