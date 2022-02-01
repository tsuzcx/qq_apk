package com.tencent.tim.cloudfile.anima;

class CloudSendAnimaActivity$1
  implements Runnable
{
  CloudSendAnimaActivity$1(CloudSendAnimaActivity paramCloudSendAnimaActivity, int paramInt, DynamicButton paramDynamicButton) {}
  
  public void run()
  {
    if (this.epZ <= 99)
    {
      CloudSendAnimaActivity.a(this.this$0, this.b, String.valueOf(this.epZ));
      return;
    }
    CloudSendAnimaActivity.a(this.this$0, this.b, "99+");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.anima.CloudSendAnimaActivity.1
 * JD-Core Version:    0.7.0.1
 */