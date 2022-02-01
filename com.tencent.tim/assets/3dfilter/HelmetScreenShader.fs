precision highp float;

uniform sampler2D defaultSampler;

varying vec2 fragTexCoord;
varying vec3 fragNormal;
varying vec4 fragCoord;

uniform mat4 m4ModelTrans;
uniform mat3 m3InverseTrans;

uniform vec3 cameraPosition;

const vec3 lightPos = vec3(-20.0, -200.0, -50.0);
const vec3 viewPos = vec3(0.0, 0.0, 200.0);
const vec3 ambientColor = vec3(0.1, 0.0, 0.0);
const vec3 diffuseColor = vec3(0.5, 0.0, 0.0);
const vec3 specColor = vec3(1.0, 1.0, 1.0);
const float shininess = 64.0;
#define M_PI 3.1415926535897932384626433832795

void main() {
    vec3 normal = normalize(m3InverseTrans * fragNormal);
    vec3 surfacePos = vec3(m4ModelTrans * fragCoord);
    vec4 surfaceColor = texture2D(defaultSampler, fragTexCoord);
    vec3 surfaceToCamera = normalize(cameraPosition - surfacePos);

    //reflect
    vec3 vertPos = fragCoord.xyz / fragCoord.w;
    vec3 lightDir = normalize(lightPos - vertPos);
    float lambertian = max(dot(lightDir, normal), 0.0);
    float specular = 0.0;
    vec3 reflectDir = vec3(0, 0, 0);
    vec3 viewDir = normalize(viewPos - vertPos);
    if (lambertian > 0.0) {
        vec3 halfDir = normalize(lightDir + viewDir);
        float specAngle = max(dot(halfDir, normal), 0.0);
        specular = pow(specAngle, shininess);
    }
    vec3 reflectColor;
    if (dot(viewDir, normal) >= 0.0) {
        vec3 skyDir = -reflect(viewDir, normal);
        float cosTheta = dot(viewDir, skyDir);
        float phi = atan(skyDir.x, skyDir.y);
        float theta = acos(cosTheta);
        vec2 uv = vec2( 0.5-0.5*theta*sin(phi)/M_PI, 0.5+0.5*theta*cos(phi)/M_PI );
        reflectColor = texture2D(defaultSampler, uv).rgb;
    } else {
        reflectColor = vec3(0.0, 0.0, 0.0);
    }
    vec3 colorLinear = ambientColor + lambertian * diffuseColor + specular * reflectColor;
    gl_FragColor = vec4(specular * specColor + reflectColor, 1.0);
    
}
