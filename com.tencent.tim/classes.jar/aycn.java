import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter;
import com.tencent.mobileqq.shortvideo.filter.QQTextEjectaFilter.EjectaTextureCallBack;
import com.tencent.qg.StoryQGSurfaceView;

class aycn
  implements QQTextEjectaFilter.EjectaTextureCallBack
{
  aycn(aycm paramaycm) {}
  
  public int[] onDrawFrame()
  {
    int[] arrayOfInt1 = new int[2];
    int[] tmp5_4 = arrayOfInt1;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    int[] arrayOfInt2 = new int[2];
    int[] tmp19_18 = arrayOfInt2;
    tmp19_18[0] = 0;
    int[] tmp23_19 = tmp19_18;
    tmp23_19[1] = 0;
    tmp23_19;
    if (!this.this$0.dyn) {
      return new int[0];
    }
    arrayOfInt1[0] = aycm.a(this.this$0).getCanvasTexture("offscreen_richard");
    if (((aycm.a(this.this$0) != null) || (aycm.a(this.this$0).drq)) && (!aycm.a(this.this$0)))
    {
      if (aycm.a(this.this$0) == 0) {
        aycm.a(this.this$0, GlUtil.createTexture(3553, aycm.a(this.this$0)));
      }
      arrayOfInt1[1] = aycm.a(this.this$0);
      arrayOfInt2[1] = 1;
    }
    aycm.a(this.this$0).setIsNeedReverseTexture(arrayOfInt2);
    return arrayOfInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aycn
 * JD-Core Version:    0.7.0.1
 */