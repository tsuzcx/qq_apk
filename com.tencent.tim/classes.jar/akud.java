import com.tencent.map.geolocation.TencentDirectionListener;

class akud
  implements TencentDirectionListener
{
  akud(akub paramakub) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (akub.a(this.this$0) != null)
    {
      akub.a(this.this$0, 180.0D + paramDouble);
      akub.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akud
 * JD-Core Version:    0.7.0.1
 */