import android.graphics.PointF;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.nio.ByteBuffer;
import java.util.List;

public class ioy
{
  public short A;
  public short B;
  public byte[] aQ = null;
  public byte[] aR = null;
  public byte[] aS = null;
  public float[] faceAngles = null;
  public int facecount = 0;
  public List<PointF> fm = null;
  public int height;
  public boolean needHMirror;
  public int width;
  
  private byte[] a(int paramInt1, int paramInt2, float paramFloat)
  {
    PointF localPointF = null;
    Object localObject = localPointF;
    if (this.fm != null)
    {
      localObject = localPointF;
      if (this.fm.size() > 0)
      {
        localObject = localPointF;
        if (paramInt1 != 0)
        {
          localObject = localPointF;
          if (paramInt2 != 0)
          {
            localObject = localPointF;
            if (paramFloat > 0.0001D)
            {
              float f = 240.0F / (paramInt1 * paramFloat);
              paramFloat = 320.0F / (paramInt2 * paramFloat);
              igd.aJ("FaceData", "getFaceFeature:" + paramInt1 + "|" + paramInt2 + "|" + f);
              localObject = ByteBuffer.allocate(this.fm.size() * 4);
              paramInt1 = 0;
              while (paramInt1 < this.fm.size())
              {
                localPointF = (PointF)this.fm.get(paramInt1);
                short s1 = (short)(int)(localPointF.x * f);
                short s2 = (short)(int)(localPointF.y * paramFloat);
                ((ByteBuffer)localObject).putShort(s1);
                ((ByteBuffer)localObject).putShort(s2);
                paramInt1 += 1;
              }
              localObject = ((ByteBuffer)localObject).array();
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private byte[] b(int paramInt1, int paramInt2, float paramFloat)
  {
    PointF localPointF = null;
    Object localObject = localPointF;
    if (this.fm != null)
    {
      localObject = localPointF;
      if (this.fm.size() > 0)
      {
        localObject = localPointF;
        if (paramInt1 != 0)
        {
          localObject = localPointF;
          if (paramInt2 != 0)
          {
            localObject = localPointF;
            if (paramFloat > 0.0001D)
            {
              float f = 2.4E+008F / (paramInt1 * paramFloat);
              paramFloat = 3.2E+008F / (paramInt2 * paramFloat);
              igd.aJ("FaceData", "getFaceFeature2:" + paramInt1 + "|" + paramInt2 + "|" + f);
              localObject = ByteBuffer.allocate(this.fm.size() * 8);
              paramInt1 = 0;
              while (paramInt1 < this.fm.size())
              {
                localPointF = (PointF)this.fm.get(paramInt1);
                paramInt2 = (int)(localPointF.x * f);
                int i = (int)(localPointF.y * paramFloat);
                ((ByteBuffer)localObject).putInt(paramInt2);
                ((ByteBuffer)localObject).putInt(i);
                paramInt1 += 1;
              }
              localObject = ((ByteBuffer)localObject).array();
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public void a(PTFaceAttr paramPTFaceAttr, float paramFloat, boolean paramBoolean)
  {
    if (paramPTFaceAttr != null)
    {
      this.facecount = paramPTFaceAttr.getFaceCount();
      if ((this.facecount > 0) && (paramPTFaceAttr != null))
      {
        if (paramBoolean) {
          break label104;
        }
        this.fm = ((List)paramPTFaceAttr.getAllFacePoints().get(0));
        this.faceAngles = ((float[])paramPTFaceAttr.getAllFaceAngles().get(0));
        this.aQ = a(this.height, this.width, paramFloat);
        this.aR = b(this.height, this.width, paramFloat);
      }
    }
    label104:
    do
    {
      return;
      this.facecount = 0;
      break;
      paramPTFaceAttr = paramPTFaceAttr.genOrigFaceData();
    } while (paramPTFaceAttr == null);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramPTFaceAttr.getBytes().length + 4);
    this.A = ((short)(int)(this.height * paramFloat));
    this.B = ((short)(int)(this.width * paramFloat));
    localByteBuffer.put(new byte[] { (byte)(this.B >> 8), (byte)(this.B >> 0), (byte)(this.A >> 8), (byte)(this.A >> 0) });
    localByteBuffer.put(paramPTFaceAttr.getBytes());
    this.aS = localByteBuffer.array();
  }
  
  public void clear(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.fm = null;
    this.faceAngles = null;
    this.facecount = 0;
    this.aQ = null;
    this.aR = null;
    this.aS = null;
    this.needHMirror = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ioy
 * JD-Core Version:    0.7.0.1
 */