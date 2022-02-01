import com.tencent.map.geolocation.TencentDirectionListener;

class aiqw
  implements TencentDirectionListener
{
  aiqw(aiqs paramaiqs) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (aiqs.a(this.this$0) != null)
    {
      aiqs.a(this.this$0, 180.0D + paramDouble);
      aiqs.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiqw
 * JD-Core Version:    0.7.0.1
 */