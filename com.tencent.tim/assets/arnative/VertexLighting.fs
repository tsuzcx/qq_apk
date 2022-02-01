

//precision highp float;
precision highp float;

uniform sampler2D defaultSampler;

varying vec2 fragTexCoord;
varying vec3 fragNormal;
varying vec4 fragCoord;

varying float lightCoeff;

void main() {
    
    //final color (after gamma correction)
    //    vec3 gamma = vec3(1.0/2.2);
    //    gl_FragColor = vec4(pow(linearColor, gamma), surfaceColor.a);
    vec4 surfaceColor = texture2D(defaultSampler, fragTexCoord);; // without gamma correction
    gl_FragColor = lightCoeff * surfaceColor;
}