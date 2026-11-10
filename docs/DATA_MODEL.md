# مدل داده اولیه MindRebuild

## موجودیت‌های اصلی

### InboxItem (صندوق ورودی)
- id
- content (متن آزاد)
- createdAt
- isProcessed (boolean)

### Task
- id
- title
- notes
- status (todo / doing / done)
- createdAt
- completedAt

### LearningTopic
- id
- title
- why (متن چرایی)
- simpleExplanation
- realProjectConnection
- summary
- status (active / paused / completed / later)
- createdAt
- lastReviewedAt

### KnowledgeEntry
- id
- title
- content
- relatedTopicId (اختیاری)
- tags
- createdAt

### CuriosityItem (بعداً)
- id
- title
- notes
- createdAt

## اصول طراحی داده

- سادگی اولویت دارد.
- هیچ ساختار پیچیده‌ای در نسخه اول وجود ندارد.
- امکان خروجی گرفتن به Markdown در آینده در نظر گرفته شده.
