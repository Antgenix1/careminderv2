# Generated by Django 4.1 on 2023-11-30 12:00

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('request', '0006_alter_chatmessage_request'),
    ]

    operations = [
        migrations.AlterField(
            model_name='request',
            name='for_role',
            field=models.PositiveSmallIntegerField(choices=[(0, 'Helper'), (1, 'Nurse'), (2, 'Doctor')]),
        ),
    ]