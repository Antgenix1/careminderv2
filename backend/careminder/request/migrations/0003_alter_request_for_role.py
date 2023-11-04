# Generated by Django 4.1.3 on 2023-11-04 13:53

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ("request", "0002_initial"),
    ]

    operations = [
        migrations.AlterField(
            model_name="request",
            name="for_role",
            field=models.PositiveSmallIntegerField(
                choices=[(0, "Secretary"), (1, "Helper"), (2, "Nurse"), (3, "Doctor")]
            ),
        ),
    ]
