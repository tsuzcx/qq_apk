#ifdef GL_FRAGMENT_PRECISION_HIGH
precision highp float;
#else
precision mediump float;
#endif

varying vec2 varTexCoord;
uniform vec4 uMaskColor;

uniform sampler2D defaultSampler;

varying vec2 fragTexCoord;
varying vec3 fragNormal;
varying vec4 fragCoord;

void main()
{
    vec4 texColor = texture2D(defaultSampler, fragTexCoord.st, 0.0);
    gl_FragColor = texColor * uMaskColor;
}
