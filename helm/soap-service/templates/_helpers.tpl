{{- define "soap-service.name" -}}
soap-service
{{- end }}

{{- define "soap-service.fullname" -}}
{{ include "soap-service.name" . }}
{{- end }}
