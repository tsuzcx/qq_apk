import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ipw
  extends ipz
{
  private final String TAG = "MultipleTextureSource-" + Integer.toHexString(hashCode());
  private List<Frame> fn = new LinkedList();
  
  public void a(List<ipw.a> paramList, long paramLong)
  {
    ArrayList localArrayList1 = new ArrayList(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      ipw.a locala = (ipw.a)paramList.get(i);
      label131:
      ArrayList localArrayList2;
      if (i >= this.fn.size())
      {
        localObject = new Frame();
        QLog.d(this.TAG, 1, "render: create cached frame#" + Integer.toHexString(localObject.hashCode()));
        ((Frame)localObject).setSizedTexture(locala.texture, locala.width, locala.arQ);
        this.fn.add(localObject);
        if (!locala.ve()) {
          break label257;
        }
        localArrayList2 = new ArrayList(1);
        iqa.a locala1 = new iqa.a();
        locala1.fo = locala.fo;
        localArrayList2.add(locala1);
      }
      label257:
      for (Object localObject = iqa.a((Frame)localObject, localArrayList2);; localObject = iqa.a((Frame)localObject))
      {
        localArrayList1.add(localObject);
        i += 1;
        break;
        localObject = (Frame)this.fn.get(i);
        ((Frame)this.fn.get(i)).setSizedTexture(locala.texture, locala.width, locala.arQ);
        break label131;
      }
    }
    b(localArrayList1, paramLong);
  }
  
  protected void onDestroy()
  {
    int i = 0;
    while (i < this.fn.size())
    {
      ((Frame)this.fn.get(i)).clear();
      QLog.d(this.TAG, 1, "onDestroy: cached frame#" + Integer.toHexString(((Frame)this.fn.get(i)).hashCode()));
      i += 1;
    }
    this.fn.clear();
    FrameBufferCache.getInstance().destroy();
  }
  
  protected void onInit() {}
  
  public static class a
  {
    public boolean Tt;
    public int arQ;
    public int arR;
    public int arS;
    public List<TTFaceOriginDataModel> fo;
    public int texture;
    public int width;
    
    public boolean ve()
    {
      return (this.arR != 0) && (this.arS != 0) && (this.fo != null) && (!this.fo.isEmpty());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipw
 * JD-Core Version:    0.7.0.1
 */