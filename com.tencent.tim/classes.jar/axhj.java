import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import dov.com.qq.im.ae.play.AEVideoShelfEditFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class axhj
  extends AsyncTask<Void, Void, Void>
{
  public axhj(AEVideoShelfEditFragment paramAEVideoShelfEditFragment) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = new Intent();
    paramVarArgs.putExtra("from", true);
    paramVarArgs.putExtra("isNeedEditButton", true);
    paramVarArgs.putExtra("usePagPreview", true);
    paramVarArgs.putExtra("videoOutWidth", AEVideoShelfEditFragment.a(this.this$0).getVideoWidth());
    paramVarArgs.putExtra("videoOutHeight", AEVideoShelfEditFragment.a(this.this$0).getVideoHeight());
    paramVarArgs.putExtra("pagFilePath", AEVideoShelfEditFragment.a(this.this$0).getPagFilePath());
    paramVarArgs.putExtra("audioFilePath", AEVideoShelfEditFragment.a(this.this$0).getAudioPath());
    paramVarArgs.putExtra("MaterialPath", AEVideoShelfEditFragment.a(this.this$0));
    paramVarArgs.putExtra("MaterialId", AEVideoShelfEditFragment.b(this.this$0));
    paramVarArgs.putExtra("MaterialName", AEVideoShelfEditFragment.a(this.this$0).getVideoName());
    paramVarArgs.putStringArrayListExtra("PhotoList", AEVideoShelfEditFragment.a(this.this$0));
    paramVarArgs.putExtra("loc_play_show_tab_name", AEVideoShelfEditFragment.c(this.this$0));
    paramVarArgs.putExtra("loc_play_show_material_id", AEVideoShelfEditFragment.b(this.this$0));
    paramVarArgs.putExtra("loc_play_show_take_same_name", AEVideoShelfEditFragment.d(this.this$0));
    paramVarArgs.putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.bI(this.this$0.getActivity()));
    HashMap localHashMap = new HashMap();
    Object localObject = AEVideoShelfEditFragment.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = ((NodeGroup)((Iterator)localObject).next()).nodeItemList.iterator();
      while (localIterator.hasNext())
      {
        NodeItem localNodeItem = (NodeItem)localIterator.next();
        if (localNodeItem.type != 1) {
          localHashMap.put(AEVideoShelfEditFragment.a(this.this$0, localNodeItem.nodeID, localNodeItem.cropBitmap), localNodeItem.indexLayerForPag);
        } else {
          localHashMap.put(AEVideoShelfEditFragment.a(this.this$0, localNodeItem.nodeID, localNodeItem.bitmap), localNodeItem.indexLayerForPag);
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("nodeImgList", localHashMap);
    paramVarArgs.putExtras((Bundle)localObject);
    AEVideoShelfEditFragment.a(this.this$0, paramVarArgs);
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    AEVideoShelfEditFragment.c(this.this$0);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    AEVideoShelfEditFragment.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axhj
 * JD-Core Version:    0.7.0.1
 */