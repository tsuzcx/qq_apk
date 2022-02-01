import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.ShelfNode;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment.OffscreenCaptureRunnable;
import java.util.ArrayList;
import java.util.List;

public class axhn
  extends AsyncTask<Void, Void, Void>
{
  public axhn(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    long l1 = System.currentTimeMillis();
    AEVideoShelfEditFragment.a(this.this$0);
    long l2 = System.currentTimeMillis();
    if (QLog.isDebugVersion()) {
      QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "init data doInBackground1---cost: ", Long.valueOf(l2 - l1) });
    }
    AEVideoShelfEditFragment.b(this.this$0);
    if (QLog.isDebugVersion()) {
      QLog.d("AEVideoShelfEditFrag", 2, new Object[] { "init data doInBackground2---cost: ", Long.valueOf(System.currentTimeMillis() - l2) });
    }
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    AEVideoShelfEditFragment.c(this.this$0);
    if (AEVideoShelfEditFragment.a(this.this$0).isEmpty())
    {
      axiy.w("AEVideoShelfEditFrag", "init NodeGroup Error!");
      return;
    }
    paramVoid = new ArrayList();
    int i = 0;
    while (i < AEVideoShelfEditFragment.a(this.this$0).size())
    {
      ShelfNode localShelfNode = new ShelfNode();
      localShelfNode.setCoverUri(((NodeGroup)AEVideoShelfEditFragment.a(this.this$0).get(i)).nodeCoverImage);
      paramVoid.add(localShelfNode);
      i += 1;
    }
    AEVideoShelfEditFragment.a(this.this$0, new axih(this.this$0.getActivity(), paramVoid, AEVideoShelfEditFragment.a(this.this$0).getVideoWidth(), AEVideoShelfEditFragment.a(this.this$0).getVideoHeight()));
    AEVideoShelfEditFragment.a(this.this$0).setMaterialPath(AEVideoShelfEditFragment.a(this.this$0).getMaterialPath());
    AEVideoShelfEditFragment.a(this.this$0).setAdapter(AEVideoShelfEditFragment.a(this.this$0));
    AEVideoShelfEditFragment.d(this.this$0);
    AEVideoShelfEditFragment.e(this.this$0);
    AEVideoShelfEditFragment.a(this.this$0, 0);
    new AEVideoShelfEditFragment.OffscreenCaptureRunnable(this.this$0, null).run();
  }
  
  protected void onPreExecute()
  {
    AEVideoShelfEditFragment.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhn
 * JD-Core Version:    0.7.0.1
 */